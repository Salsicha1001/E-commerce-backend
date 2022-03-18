package com.ecommerceback.Model.Card.Response;

import java.util.ArrayList;
import java.util.List;

public class CardResume {

    private Long id;
    private String name;
    private List<CardsImagesDtoResponse> card_images = new ArrayList<>();

    public CardResume() {
    }

    public CardResume(Long id, String name, List<CardsImagesDtoResponse> card_images) {
        this.id = id;
        this.name = name;
        this.card_images = card_images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CardsImagesDtoResponse> getCard_images() {
        return card_images;
    }

    public void setCard_images(List<CardsImagesDtoResponse> card_images) {
        this.card_images = card_images;
    }
}
