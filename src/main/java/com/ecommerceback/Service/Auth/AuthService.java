package com.ecommerceback.Service.Auth;

import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.Request.CredentialsRequestDto;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Repository.Auth.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Object saveAuthUser(UserModel user, UserCreatedDtoRequest request){
      return authenticationRepository.save(convertAuth(user,request)) ;
    }
    public AuthenticatorModel getPasswordUser(UserModel id){
     return  authenticationRepository.findByUser(id);
    }


    private AuthenticatorModel convertAuth(UserModel user, UserCreatedDtoRequest request){
        AuthenticatorModel auth = new AuthenticatorModel();
        auth.setUser(user);
        auth.setPassword(request.getPassword());
        return  auth;
    }
}
