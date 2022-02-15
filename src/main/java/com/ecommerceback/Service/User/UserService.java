package com.ecommerceback.Service.User;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.Enum.TypeUser;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Repository.User.UserRepository;
import com.ecommerceback.Service.Auth.AuthService;
import com.ecommerceback.Service.Localization.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AuthService authService;


    public UserModel createUser(UserCreatedDtoRequest userCreated){
            UserModel u= userRepository.save(convertUserModel(userCreated));
            AuthenticatorModel auth= (AuthenticatorModel) authService.saveAuthUser(u,userCreated);
            List<LocalizationModel> localizationModels = (List<LocalizationModel>) addressService.AddressCreated(userCreated, u);
        return u;



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
