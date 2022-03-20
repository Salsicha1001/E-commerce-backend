package com.ecommerceback.Model.Preferences;

import java.lang.reflect.Type;

public enum PreferencesTypesEnum {
    BOOLEAN(Boolean.class),
    INTEGER(Integer.class),
    STRING(String.class);

    private final Type descType;

    PreferencesTypesEnum(Type descType){
        this.descType = descType;
    }

    public Object convertValuePreference(PreferencesModel pModel){
        switch(pModel.getTypeValue()){
            case BOOLEAN:
                return Boolean.valueOf(pModel.getValueConfig());
            case INTEGER:
                return Integer.parseInt(pModel.getValueConfig());
            case STRING:
                return String.valueOf(pModel.getValueConfig());
            default:
                return null;
        }
    }

}
