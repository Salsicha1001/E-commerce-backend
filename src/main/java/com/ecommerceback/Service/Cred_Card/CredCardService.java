package com.ecommerceback.Service.Cred_Card;

import com.ecommerceback.Model.User.CardUserModel;
import com.ecommerceback.Model.User.Request.CredCardRequestDto;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Repository.Cred_Card.CredCardRepository;
import com.ecommerceback.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredCardService {
    @Autowired
    private UserService userService;
    @Autowired
    private CredCardRepository credCardRepository;


public ResponseEntity<?> saveCardUser(CredCardRequestDto cred){
    UserModel u = userService.findByID(cred.getId_user());
        CardUserModel cart = new CardUserModel();
        cart.setCvv(cred.getCvv());
        cart.setName_card(cred.getName_card());
        cart.setNumber_card(cred.getNumber_card());
        cart.setUser_id(u);
        cart.setExpired(cred.getExpired());
        credCardRepository.save(cart);
       return ResponseEntity.status(HttpStatus.CREATED).body(ResponseModel.ok("Salvo"));
}

public ResponseEntity<?> deleteCredCard(Long id){
    CardUserModel cart = credCardRepository.getById(id);
    credCardRepository.delete(cart);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseModel.ok("Deletado"));
}

    public ResponseEntity<?> getCredCart(Long id_user){
        UserModel u = userService.findByID(id_user);
        List<CardUserModel> cart =credCardRepository.findAllByUser(u.getId_user());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseModel.ok("Achado", cart));
    }
}
