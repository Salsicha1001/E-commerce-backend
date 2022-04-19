package com.ecommerceback.Controller.User;

import com.ecommerceback.Model.User.Request.CredentialsRequestDto;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Service.Auth.AuthService;
import com.ecommerceback.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody CredentialsRequestDto credentialsRequestDto){
        return userService.login(credentialsRequestDto);
    }



    @PostMapping("/add")
    public ResponseEntity<?> CreatedUser( @RequestBody UserCreatedDtoRequest user){
        UserModel isExistUser = userService.findByCPF(user.getCpf());
        if(isExistUser == null) {
            UserModel u = userService.createUser(user);
            return  ResponseEntity.status(HttpStatus.CREATED).body(ResponseModel.created("Conta criada com sucesso",u.getEmail()));
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(ResponseModel.error("Usuário com esse CPF ja cadastrado"));
        }
    }

    @GetMapping("/email")
      public ResponseEntity<?> find(@RequestParam String email) {
            UserModel obj = userService.findByEmail(email);
            if (obj != null) {
                return ResponseEntity.ok().body(obj);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                        .body(ResponseModel.error("Usuário não encontrado"));
            }
        }



}
