package com.ecommerceback.Model.User.Request;

import java.io.Serializable;

public class CredentialsRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    public CredentialsRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CredentialsRequestDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
