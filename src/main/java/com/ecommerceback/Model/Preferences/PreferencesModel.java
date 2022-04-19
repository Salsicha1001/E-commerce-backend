package com.ecommerceback.Model.Preferences;

import com.ecommerceback.Model.User.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;


@Entity
public class PreferencesModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ed;
    private String language;
    private Boolean theme;
    @OneToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserModel userModel;




    public PreferencesModel() {
    }


    public PreferencesModel(Long id_ed, String language, Boolean theme,  UserModel userModel) {
        this.id_ed = id_ed;
        this.language = language;
        this.theme = theme;
        this.userModel = userModel;
    }

    public Long getId_ed() {
        return id_ed;
    }

    public void setId_ed(Long id_ed) {
        this.id_ed = id_ed;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getTheme() {
        return theme;
    }

    public void setTheme(Boolean theme) {
        this.theme = theme;
    }


    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }


}
