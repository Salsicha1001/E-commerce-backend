package com.ecommerceback.Model.Preferences.Response;

import com.ecommerceback.Model.Preferences.PreferencesModel;
import com.ecommerceback.Model.User.UserModel;

import java.util.ArrayList;
import java.util.List;

public class PreferencesDtoResponse {
    private UserModel user;
    private List<PreferencesModel> preferences = new ArrayList<>();

    public PreferencesDtoResponse() {
    }

    public PreferencesDtoResponse(UserModel user, List<PreferencesModel> preferences) {
        this.user = user;
        this.preferences = preferences;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<PreferencesModel> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PreferencesModel> preferences) {
        this.preferences = preferences;
    }
}
