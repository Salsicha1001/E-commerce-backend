package com.ecommerceback.Model.Localization;

import com.ecommerceback.Model.User.UserModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LocalizationModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ed;
    private String street;
    private String district;
    private String city;
    private String state;
    private String number_address;
    private String complement;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;
    public LocalizationModel() {
    }

    public LocalizationModel(Long id_ed, String street, String district, String city, String state, String number_address, String complement, String cep, UserModel user) {
        this.id_ed = id_ed;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number_address = number_address;
        this.complement = complement;
        this.cep = cep;
        this.user = user;
    }

    public Long getId_ed() {
        return id_ed;
    }

    public void setId_ed(Long id_ed) {
        this.id_ed = id_ed;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
