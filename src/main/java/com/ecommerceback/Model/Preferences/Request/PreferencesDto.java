package com.ecommerceback.Model.Preferences.Request;

import com.ecommerceback.Model.User.UserModel;

public class PreferencesDto {

    private Long id_ed;
    private String configName;
    private String valueConfig;
    private Class<?> typeValue;
    private UserModel userModel;


    public PreferencesDto() {
    }

    public PreferencesDto(Long id_ed, String configName, String valueConfig, Class<?> typeValue, UserModel userModel) {
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

    public Class<?> getTypeValue() {
        return this.typeValue;
    }

    public void setTypeValue(Class<?> typeValue) {
        this.typeValue = typeValue;
    }

    public UserModel getUserModel() {
        return this.userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

}
