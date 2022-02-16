package com.ecommerceback.Model.User.Request;

import com.ecommerceback.Model.User.Enum.TypeUser;
import com.ecommerceback.Utils.Crypto.Decrypt;
import com.ecommerceback.Utils.ValidCPF.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserDtoRequest {
    @NotBlank(message = "Campo Nome não pode ser vazio")
    private String name;
    @Email(message="Email Invalido")
    private String email;
    @NotBlank(message = "Campo CPF não pode ser vazio")
    @CPF(message = "CPF Invalido")
    @Column(unique = true)
    private String cpf;
    @Decrypt
    private String phone;
    @Min(value = 1,message = "Usuário não valido")
    @Max(value = 3,message = "Usuário não valido")
    private Integer typeUser;

    public UserDtoRequest() {
    }

    public UserDtoRequest(String name, String email, String cpf, String phone, Integer typeUser) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.typeUser = typeUser;
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


}
