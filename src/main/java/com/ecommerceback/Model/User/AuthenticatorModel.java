package com.ecommerceback.Model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class AuthenticatorModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_auth;
    @OneToOne
    private UserModel user;
    @NotNull
    private String password;

    public AuthenticatorModel() {
    }

    public AuthenticatorModel(Long id_auth, UserModel user, String password) {
        this.id_auth = id_auth;
        this.user = user;
        this.password = password;
    }

    public Long getId_auth() {
        return id_auth;
    }

    public void setId_auth(Long id_auth) {
        this.id_auth = id_auth;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
