package com.ecommerceback.Model.Preferences.Request;

import com.ecommerceback.Model.Preferences.PreferencesTypesEnum;

public class PreferencesDto {

    private String configName;
    private String valueConfig;
    private PreferencesTypesEnum typeValue;


    public PreferencesDto() {
    }

    public PreferencesDto(String configName, String valueConfig, PreferencesTypesEnum typeValue) {
        this.configName = configName;
        this.valueConfig = valueConfig;
        this.typeValue = typeValue;
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

}
