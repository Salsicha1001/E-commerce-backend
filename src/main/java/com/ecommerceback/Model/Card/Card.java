package com.ecommerceback.Model.Card;

import com.ecommerceback.Model.User.UserModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Card implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_card;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;

    public Card() {
    }
    public Card(Long id, Long id_card, UserModel user) {
        this.id = id;
        this.id_card = id_card;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
