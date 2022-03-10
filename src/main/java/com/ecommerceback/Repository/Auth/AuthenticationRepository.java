package com.ecommerceback.Repository.Auth;

import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticatorModel,Long> {

    @Transactional(readOnly=true)
    AuthenticatorModel findByUser(UserModel id);

}
