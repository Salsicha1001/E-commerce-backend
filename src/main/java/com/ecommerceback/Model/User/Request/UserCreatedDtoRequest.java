package com.ecommerceback.Model.User.Request;

import com.ecommerceback.Model.Localization.Request.AddressDto;

import java.util.ArrayList;
import java.util.List;

public class UserCreatedDtoRequest extends AuthDtoRequest{


    private List<AddressDto> address_user = new ArrayList<AddressDto>();


    public UserCreatedDtoRequest(String name, String email, String cpf, String phone, Integer typeUser, String password, List<AddressDto> address_user) {
        super(name, email, cpf, phone, typeUser, password);
        this.address_user = address_user;
    }

    public UserCreatedDtoRequest() {
    }


    public List<AddressDto> getAddress_user() {
        return address_user;
    }

    public void setAddress_user(List<AddressDto> address_user) {
        this.address_user = address_user;
    }
}
