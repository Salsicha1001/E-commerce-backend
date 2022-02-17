package com.ecommerceback.Model.Localization.Response;

import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.Localization.Request.AddressDto;
import com.ecommerceback.Model.User.UserModel;

import java.util.ArrayList;
import java.util.List;

public class AddressUserDtoResponse {
    private UserModel user;
    private List<LocalizationModel> address = new ArrayList<>();

    public AddressUserDtoResponse() {
    }

    public AddressUserDtoResponse(UserModel user, List<LocalizationModel> address) {
        this.user = user;
        this.address = address;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<LocalizationModel> getAddress() {
        return address;
    }

    public void setAddress(List<LocalizationModel> address) {
        this.address = address;
    }
}
