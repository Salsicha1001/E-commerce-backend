package com.ecommerceback.Controller.Preferences;

import com.ecommerceback.Model.Preferences.Request.PreferencesDto;
import com.ecommerceback.Service.Preferences.PreferencesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preferences")
public class PreferencesController {
    @Autowired
    private PreferencesService preferencesService;

    @PostMapping("/register/{idUser}")
    public ResponseEntity<?> registerPreference(@RequestBody PreferencesDto preferences, @PathVariable String idUser){
        Long tmp = Long.valueOf(idUser);
        return preferencesService.RegisterPreference(preferences,tmp);
    }

    @GetMapping("/all/{idUser}")
    public ResponseEntity<?> getAllPreferencesByUser(@PathVariable String idUser){
        return preferencesService.getPreferencesByUser(Long.parseLong(idUser));
    }

    @GetMapping("/{preferenceName}/{idUser}")
    public ResponseEntity<?> findPreferenceByNameAndUser(@PathVariable String preferenceName,
                                                 @PathVariable String idUser){
        return preferencesService.findPreferenceByNameAndUser(preferenceName,Long.parseLong(idUser));
    }



}
