package com.ecommerceback.Model.User.Request;

public class AuthDtoRequest extends UserDtoRequest {
    String password;

    public AuthDtoRequest() {
    }

    public AuthDtoRequest(String name, String email, String cpf, String phone, Integer typeUser, String password) {
        super(name, email, cpf, phone, typeUser);
        this.password = password;
    }

    public AuthDtoRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
