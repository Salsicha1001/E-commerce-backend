package com.ecommerceback.Model.User.Response;


import com.ecommerceback.Model.Preferences.PreferencesModel;
import com.ecommerceback.Model.User.Enum.TypeUser;

import java.util.Set;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private PreferencesModel roles;
     private String typeUser;
    public JwtResponse(String accessToken, String name, String username, long id, PreferencesModel roles, String typeUser) {
        this.token = accessToken;
        this.username = name;
        this.email = username;
        this.id = id;
        this.roles = roles;
        this.typeUser = typeUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PreferencesModel getRoles() {
        return roles;
    }

    public void setRoles(PreferencesModel roles) {
        this.roles = roles;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}