package com.ecommerceback.Model.Localization.Request;

public class AddressDto {
    private String street;
    private String district;
    private String city;
    private String state;
    private String number_address;
    private String complement;
    private String cep;

    public AddressDto() {
    }

    public AddressDto(String street, String district, String city, String state, String number_address, String complement, String cep) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number_address = number_address;
        this.complement = complement;
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber_address() {
        return number_address;
    }

    public void setNumber_address(String number_address) {
        this.number_address = number_address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
