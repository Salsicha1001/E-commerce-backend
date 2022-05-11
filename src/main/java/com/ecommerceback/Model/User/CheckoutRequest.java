package com.ecommerceback.Model.User;

import com.ecommerceback.Model.Card.CardOrders;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CheckoutRequest implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserModel userId;
    @OneToMany
    private List<CardOrders> cardOrders = new ArrayList<CardOrders>();
    private String codOrders;
    private String totalValue;

    private String dateShopp;
    private String hourShopp;
    @ManyToOne
    private CardUserModel credCard;

    public CheckoutRequest() {
    }

    public CheckoutRequest(Long id, UserModel userId, List<CardOrders> cardOrders, String codOrders, String totalValue, String dateShopp, String hourShopp, CardUserModel credCard) {
        this.id = id;
        this.userId = userId;
        this.cardOrders = cardOrders;
        this.codOrders = codOrders;
        this.totalValue = totalValue;
        this.dateShopp = dateShopp;
        this.hourShopp = hourShopp;
        this.credCard = credCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    public List<CardOrders> getCardOrders() {
        return cardOrders;
    }

    public void setCardOrders(List<CardOrders> cardOrders) {
        this.cardOrders = cardOrders;
    }

    public String getCodOrders() {
        return codOrders;
    }

    public void setCodOrders(String codOrders) {
        this.codOrders = codOrders;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getDateShopp() {
        return dateShopp;
    }

    public void setDateShopp(String dateShopp) {
        this.dateShopp = dateShopp;
    }

    public String getHourShopp() {
        return hourShopp;
    }

    public void setHourShopp(String hourShopp) {
        this.hourShopp = hourShopp;
    }

    public CardUserModel getCredCard() {
        return credCard;
    }

    public void setCredCard(CardUserModel credCard) {
        this.credCard = credCard;
    }
}
