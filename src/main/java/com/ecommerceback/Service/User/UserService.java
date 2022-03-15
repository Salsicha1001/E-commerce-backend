package com.ecommerceback.Service.User;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.Enum.TypeUser;
import com.ecommerceback.Model.User.Request.CredentialsRequestDto;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.Response.JwtResponse;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Repository.User.UserRepository;
import com.ecommerceback.Service.Auth.AuthService;
import com.ecommerceback.Service.Localization.AddressService;
import com.ecommerceback.Utils.Security.JWTUtil;
import com.ecommerceback.Utils.Security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AuthService authService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    public ResponseEntity<?> login(CredentialsRequestDto cred){
        UserModel user =findByEmail(cred.getEmail());
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseModel.error("Não existe esse E-mail,por favor faça o cadastro"));
        }else{
            AuthenticatorModel auth = authService.getPasswordUser(user);
            if(bCryptPasswordEncoder.matches (cred.getPassword(),auth.getPassword())== true){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtil.generateJwtToken(authentication);
                UserSS userDetails = (UserSS) authentication.getPrincipal();

                return  ResponseEntity.status(HttpStatus.OK).body(ResponseModel.ok("Logado com sucesso",new JwtResponse(jwt,
                       user.getName(), userDetails.getUsername(), userDetails.getId())));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ResponseModel.ok("Senha valido"));
            }
        }


    }
    public UserModel createUser(UserCreatedDtoRequest userCreated){
            UserModel u= userRepository.save(convertUserModel(userCreated));
            userCreated.setPassword(bCryptPasswordEncoder.encode(userCreated.getPassword()));
            AuthenticatorModel auth= (AuthenticatorModel) authService.saveAuthUser(u,userCreated);
            List<LocalizationModel> localizationModels = (List<LocalizationModel>) addressService.AddressCreated(userCreated.getAddress_user(), u);
        return u;
    }
    public UserModel findByEmail(String email) {
        UserModel obj = userRepository.findByEmail(email);
            return obj;
    }
    public UserModel findByCPF(String cpf) {
        UserModel obj = userRepository.findByCpf(cpf);
            return obj;
    }

    public UserModel findByID(Long id) {
        Optional<UserModel> obj = userRepository.findById(id);
        if(!obj.isPresent()){
            return null;
        }
        return obj.get();
}


    public ResponseEntity<?> addAddressUser(AddressRequestDto address){
        UserModel user =  findByID(address.getId_user());
        if(user == null){
            return new ResponseEntity<>(ResponseModel.error("Usuario não encontrado"),HttpStatus.NOT_FOUND);
        }
        Object localizationModels =  addressService.AddressCreated(address.getAddress(),user);
        return new ResponseEntity<>(localizationModels, HttpStatus.CREATED);
    }


    private UserModel convertUserModel(UserCreatedDtoRequest user){
         UserModel newUser = new UserModel();
         newUser.setName(user.getName());
         newUser.setEmail(user.getEmail());
         newUser.setCpf(user.getCpf());
         newUser.setPhone(user.getPhone());
         newUser.setTypeUser(user.getTypeUser().getDescription()!= null?user.getTypeUser().getCode()==1?TypeUser.ADMIN:user.getTypeUser().getCode()==2?TypeUser.USER:TypeUser.SELLER_USER:TypeUser.USER);
         return newUser;
    }



}
