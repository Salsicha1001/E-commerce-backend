package com.ecommerceback.Model.User.Request;

public class CredCardRequestDto {
    private Long id;
    private Long id_user;

    private String number_card;

    private String expired;

    private String cvv;

    private String name_card;

    public CredCardRequestDto() {

    }

    public CredCardRequestDto(Long id, Long id_user, String number_card, String expired, String cvv, String name_card) {
        this.id = id;
        this.id_user = id_user;
        this.number_card = number_card;
        this.expired = expired;
        this.cvv = cvv;
        this.name_card = name_card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getNumber_card() {
        return number_card;
    }

    public void setNumber_card(String number_card) {
        this.number_card = number_card;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getName_card() {
        return name_card;
    }

    public void setName_card(String name_card) {
        this.name_card = name_card;
    }
}
