package com.ecommerceback.Controller.CredCard;

import com.ecommerceback.Model.User.Request.CredCardRequestDto;
import com.ecommerceback.Service.Cred_Card.CredCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cred-card")
public class CredCardController {
    @Autowired
    private CredCardService credCardService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCardUser(@RequestBody CredCardRequestDto credCardRequestDto) {
        return credCardService.saveCardUser(credCardRequestDto);
    }
    @GetMapping("")
    public ResponseEntity<?> getCartId(@RequestParam Long id){
        return credCardService.getCredCart(id);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteCart(@RequestParam Long id){
        return credCardService.deleteCredCard(id);
    }

}
