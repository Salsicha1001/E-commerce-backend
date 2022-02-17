package com.ecommerceback.Model.Localization.Request;


import java.util.List;

public class AddressRequestDto {

   private long id_user;
   private List<AddressDto> address;
    public AddressRequestDto() {
    }


    public AddressRequestDto(long id_user, List<AddressDto> address) {
        this.id_user = id_user;
        this.address = address;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public List<AddressDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }
}
