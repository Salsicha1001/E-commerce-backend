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
    private String configName;
    private String valueConfig;
    private PreferencesTypesEnum typeValue;
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserModel userModel;

    @Transient
    @JsonIgnore
    private Object convertedConfig;


    public PreferencesModel() {
    }


    public PreferencesModel(Long id_ed, String configName, String valueConfig, PreferencesTypesEnum typeValue, UserModel userModel) {
        this.id_ed = id_ed;
        this.configName = configName;
        this.valueConfig = valueConfig;
        this.typeValue = typeValue;
        this.userModel = userModel;
    }


    public Long getId_ed() {
        return this.id_ed;
    }

    public void setId_ed(Long id_ed) {
        this.id_ed = id_ed;
    }

    public String getConfigName() {
        return this.configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getValueConfig() {
        return this.valueConfig;
    }

    public void setValueConfig(String valueConfig) {
        this.valueConfig = valueConfig;
    }

    public PreferencesTypesEnum getTypeValue() {
        return this.typeValue;
    }

    public void setTypeValue(PreferencesTypesEnum typeValue) {
        this.typeValue = typeValue;
    }

    public UserModel getUserModel() {
        return this.userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public Object getConvertedConfig(){
        return this.convertedConfig;
    }

    public void setConvertedConfig(){
        this.convertedConfig = typeValue.convertValuePreference(this);
    }


    @Override
    public String toString() {
        return "PreferencesModel{" +
            " id_ed='" + getId_ed() + "'" +
            ", configName='" + getConfigName() + "'" +
            ", valueConfig='" + getValueConfig() + "'" +
            ", typeValue='" + getTypeValue() + "'" +
            ", userModel='" + getUserModel() + "'" +
            "}";
    }



}
