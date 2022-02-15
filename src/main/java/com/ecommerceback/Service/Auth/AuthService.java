package com.ecommerceback.Service.Auth;

import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Repository.Auth.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Object saveAuthUser(UserModel user, UserCreatedDtoRequest request){
      return authenticationRepository.save(convertAuth(user,request)) ;
    }



    private AuthenticatorModel convertAuth(UserModel user, UserCreatedDtoRequest request){
        AuthenticatorModel auth = new AuthenticatorModel();
        auth.setUser(user);
        auth.setPassword(request.getPassword());
        return  auth;
    }
}
