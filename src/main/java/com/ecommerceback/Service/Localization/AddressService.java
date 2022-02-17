package com.ecommerceback.Service.Localization;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.Localization.Request.AddressDto;
import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Model.Localization.Response.AddressUserDtoResponse;
import com.ecommerceback.Model.User.Request.UserCreatedDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Model.Util.ResponseModel;
import com.ecommerceback.Repository.Localization.LocalizationRepository;
import com.ecommerceback.Service.Exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
@Autowired
private LocalizationRepository localizationRepository;


public Object AddressCreated(List<AddressDto> userCreatedDtoRequest, UserModel user){
   List<LocalizationModel> localizationModels =convertObjectAddress(userCreatedDtoRequest,user);
   return localizationRepository.saveAll(localizationModels);

}

public ResponseEntity<?> getAddressByUser(Long id){
   List<LocalizationModel> list = localizationRepository.findAllByUser(id);
   if(list.size()==0){
      return new ResponseEntity<>("Não tem Endereços Cadastrados", HttpStatus.NOT_FOUND);
   }
   return new ResponseEntity<AddressUserDtoResponse>(new AddressUserDtoResponse(list.get(0).getUser(),list), HttpStatus.OK);
}

public ResponseEntity<?> removeAddress(Long id){
  LocalizationModel local =  getAddressId(id);
  if(local ==null){
     return new ResponseEntity<>("Esse Endereço não existe, cadastre um novo novamente",HttpStatus.BAD_REQUEST);
  }else {
      try {
          localizationRepository.deleteById(id);
          return new ResponseEntity(ResponseModel.ok("Removido com sucesso"), HttpStatus.NO_CONTENT);
      } catch (DataIntegrityViolationException e) {
          throw new DataIntegrityException("Não é possível excluir ");
      }
  }
}

   public LocalizationModel getAddressId(Long id){
       Optional<LocalizationModel> local = localizationRepository.findById(id);
       if(!local.isPresent()){
           return null;
       }
         return local.get();
   }



private List<LocalizationModel> convertObjectAddress(List<AddressDto> addressDto ,UserModel u){
   List<LocalizationModel> addressUser = new ArrayList<>();
   for(AddressDto address:addressDto){
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
