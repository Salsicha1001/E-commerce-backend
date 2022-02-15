package com.ecommerceback.Repository.Auth;

import com.ecommerceback.Model.User.AuthenticatorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticatorModel,Long> {
}
