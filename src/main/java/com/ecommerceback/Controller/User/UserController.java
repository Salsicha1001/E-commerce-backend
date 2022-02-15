package com.ecommerceback.Controller.User;

import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity CreatedUser(@Valid @RequestBody UserCreatedDtoRequest user){
       UserModel u =   userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(u.getId_user()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
