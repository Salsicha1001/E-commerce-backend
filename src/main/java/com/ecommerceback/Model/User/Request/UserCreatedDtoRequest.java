package com.ecommerceback.Model.User.Request;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.Localization.Request.AddressRequestDto;
import com.ecommerceback.Model.User.Enum.TypeUser;
import com.ecommerceback.Utils.Annotations.CPF;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserCreatedDtoRequest {
    @NotBlank(message = "Campo Nome não pode ser vazio")
    private String name;
    @Email(message="Email Invalido")
    private String email;
    @NotBlank(message = "Campo CPF não pode ser vazio")
    @CPF
    private String cpf;
    private String phone;

    private Integer typeUser;
    private String password;
    private List<AddressRequestDto> address_user = new ArrayList<AddressRequestDto>();

    public UserCreatedDtoRequest() {
    }

    public UserCreatedDtoRequest(String name, String email, String cpf, String phone, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.typeUser = typeUser;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeUser getTypeUser() {
        return TypeUser.toEnum(typeUser);
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
