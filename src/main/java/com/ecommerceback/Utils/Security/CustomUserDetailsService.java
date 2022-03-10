package com.ecommerceback.Utils.Security;

import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Repository.Auth.AuthenticationRepository;
import com.ecommerceback.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userService;
    @Autowired
    private AuthenticationRepository authenticationRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = userService.findByEmail(s);
        AuthenticatorModel auth = authenticationRepository.findByUser(user);
        if(auth.getUser().getEmail()!=""){
            return UserSS.build(auth);
        }
        return null;
    }
}
