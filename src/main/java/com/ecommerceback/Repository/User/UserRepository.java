package com.ecommerceback.Repository.User;

import com.ecommerceback.Model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    @Transactional(readOnly=true)
    UserModel findByEmail(String email);
    @Transactional(readOnly=true)
    UserModel findByCpf(String cpf);
}
