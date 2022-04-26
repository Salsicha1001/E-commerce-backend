package com.ecommerceback.Model.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CardUserModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_card;
    @ManyToOne
    private UserModel user_id;

    private String number_card;

    private String expired;

    private String cvv;

    private String name_card;

    public CardUserModel() {
    }


    public CardUserModel(Long id_card, UserModel user_id, String number_card, String expired, String cvv, String name_card) {
        this.id_card = id_card;
        this.user_id = user_id;
        this.number_card = number_card;
        this.expired = expired;
        this.cvv = cvv;
        this.name_card = name_card;
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public UserModel getUser_id() {
        return user_id;
    }

    public void setUser_id(UserModel user_id) {
        this.user_id = user_id;
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
