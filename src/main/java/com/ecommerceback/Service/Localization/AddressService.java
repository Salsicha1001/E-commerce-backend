package com.ecommerceback.Service.Localization;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Repository.Localization.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AddressService {
@Autowired
private LocalizationRepository localizationRepository;


public Object AddressCreated(UserCreatedDtoRequest userCreatedDtoRequest, UserModel user){
   List<LocalizationModel> localizationModels =convertObjectAddress(userCreatedDtoRequest,user);
   return localizationRepository.saveAll(localizationModels);

}



private List<LocalizationModel> convertObjectAddress(UserCreatedDtoRequest user ,UserModel u){
   List<LocalizationModel> addressUser = new ArrayList<>();
   for(AddressRequestDto address:user.getAddress_user()){
      LocalizationModel ad = new LocalizationModel();
      ad.setCep(address.getCep());
      ad.setCity(address.getCity());
      ad.setDistrict(address.getDistrict());
      ad.setNumber_address(address.getNumber_address());
      ad.setStreet(address.getStreet());
      ad.setComplement(address.getComplement());
      ad.setState(address.getState());
      ad.setUser(u);
      addressUser.add(ad);
}
   return  addressUser;
}
}
