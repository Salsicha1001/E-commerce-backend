package com.ecommerceback.Model.Preferences.Request;

public class PreferencesDto {

    private Boolean theme;
    private String language;


    public PreferencesDto() {
    }


    public PreferencesDto(Boolean theme, String language) {
        this.theme = theme;
        this.language = language;
    }

    public Boolean getTheme() {
        return theme;
    }

    public void setTheme(Boolean theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

