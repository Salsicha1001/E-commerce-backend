package com.ecommerceback.Controller.Preferences;

import com.ecommerceback.Model.Preferences.Request.PreferencesDto;
import com.ecommerceback.Service.Preferences.PreferencesService;
import com.ecommerceback.Service.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preferences")
public class PreferencesController {
    @Autowired
    private PreferencesService preferencesService;
    @Autowired
    private UserService userService;

    @PostMapping("/register/{id_user}")
    public ResponseEntity<?> addAddress(@RequestBody PreferencesDto preferences, @PathVariable long idUser){
        preferences.setUserModel(userService.findByID(idUser));
        return preferencesService.RegisterPreference(preferences);
    }

    @GetMapping("/all/{id_user}")
    public ResponseEntity<?> getAllPreferencesByUser(@PathVariable long id_user){
        return preferencesService.getPreferencesByUser(id_user);
    }



}
