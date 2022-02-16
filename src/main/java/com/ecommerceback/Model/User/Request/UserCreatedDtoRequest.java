package com.ecommerceback.Model.User.Request;

import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Model.User.Enum.TypeUser;
import com.ecommerceback.Utils.Crypto.Decrypt;
import com.ecommerceback.Utils.ValidCPF.CPF;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class UserCreatedDtoRequest extends UserDtoRequest{

    private String password;
    private List<AddressRequestDto> address_user = new ArrayList<AddressRequestDto>();

    public UserCreatedDtoRequest() {
    }
    public UserCreatedDtoRequest(String name, String email, String cpf, String phone, Integer typeUser, String password, List<AddressRequestDto> address_user) {
        super(name, email, cpf, phone, typeUser);
        this.password = password;
        this.address_user = address_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressRequestDto> getAddress_user() {
        return address_user;
    }

    public void setAddress_user(List<AddressRequestDto> address_user) {
        this.address_user = address_user;
    }
}
