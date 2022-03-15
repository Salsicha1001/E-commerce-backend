package com.ecommerceback.Service.Preferences;

import java.util.List;

import com.ecommerceback.Model.Preferences.PreferencesModel;
import com.ecommerceback.Model.Preferences.Request.PreferencesDto;
import com.ecommerceback.Model.Preferences.Response.PreferencesDtoResponse;
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
        PreferencesModel pModel = convertObjectPreferences(pDto, idUser);
        List<PreferencesModel> list = preferencesRepository.findAllByUser(pModel.getUserModel().getId_user());
        if (list.size() > 0){
            for(PreferencesModel pM:list){
                if(pM.getConfigName() == pModel.getConfigName()){
                    pM.setValueConfig(pModel.getValueConfig());
                    pModel = pM;
                    
                }
            }
        }
        if(preferencesRepository.save(pModel) != null){
            return new ResponseEntity<>("As configurações foram alteradas com sucesso",HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("As configurações não foram alteradas com sucesso",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> getPreferencesByUser(long id_user) {
        List<PreferencesModel> list = preferencesRepository.findAllByUser(id_user);
        if(list.size()==0){
            return new ResponseEntity<>("Não tem Configurações Cadastradas", HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<PreferencesDtoResponse>(new PreferencesDtoResponse(list.get(0).getUserModel(),list), HttpStatus.OK);
    }

    private PreferencesModel convertObjectPreferences(PreferencesDto preferencesDto, Long idUser){
        PreferencesModel pModel = new PreferencesModel();
        pModel.setConfigName(preferencesDto.getConfigName());
        pModel.setValueConfig(preferencesDto.getValueConfig());
        pModel.setTypeValue(preferencesDto.getTypeValue());
        if(idUser != null){
            pModel.setUserModel(userService.findByID(idUser));
        }
        return pModel;
    }

}
