package com.ecommerceback.Repository.Cred_Card;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.CardUserModel;
import com.ecommerceback.Model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CredCardRepository extends JpaRepository<CardUserModel,Long> {
    @Query(value = "SELECT * FROM CARD_USER_MODEL  WHERE USER_ID_ID_USER=:id ",nativeQuery = true)
    List<CardUserModel> findAllByUser(@Param("id")Long id);
}
