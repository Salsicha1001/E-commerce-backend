package com.ecommerceback.Controller.Localization;

import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Service.Localization.AddressService;
import com.ecommerceback.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localization")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody AddressRequestDto address){
        return userService.addAddressUser(address);
    }
    @GetMapping("/all/{id_user}")
    public ResponseEntity<?> getAllAddressByUser(@PathVariable long id_user){
        return addressService.getAddressByUser(id_user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddressFromUser(@PathVariable long id){
        return addressService.removeAddress(id);
    }






}
