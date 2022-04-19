package com.ecommerceback.Service.Preferences;

import java.util.List;

import com.ecommerceback.Model.Preferences.PreferencesModel;
import com.ecommerceback.Model.Preferences.Request.PreferencesDto;
import com.ecommerceback.Model.Preferences.Response.PreferencesDtoResponse;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Repository.Preferences.PreferencesRepository;
import com.ecommerceback.Service.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PreferencesService {
    @Autowired
    private PreferencesRepository preferencesRepository;
    @Autowired
    private UserService userService;

    public ResponseEntity<?> RegisterPreference(PreferencesDto pDto, Long idUser){
        PreferencesModel pModel   = convertObjectPreferences(pDto, idUser);
        if(preferencesRepository.save(pModel) != null){
            return new ResponseEntity<>("As configurações foram alteradas com sucesso",HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("As configurações não foram alteradas com sucesso",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> getPreference( Long idUser){
        PreferencesModel pmodel = preferencesRepository.findByUser(idUser);
            return new ResponseEntity<>(ResponseModel.ok("",pmodel),HttpStatus.OK);

    }



    private PreferencesModel convertObjectPreferences(PreferencesDto preferencesDto, Long idUser){
        PreferencesModel pModel ;
            pModel = preferencesRepository.findByUser(idUser);
            pModel.setTheme(preferencesDto.getTheme());
            pModel.setLanguage(preferencesDto.getLanguage());
        return pModel;
    }


}
