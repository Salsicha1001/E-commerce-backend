package com.ecommerceback.Model.Card.Response;

import java.util.ArrayList;
import java.util.List;

public class CardResume {

    private Long id;
    private String name;
    private String imageSmall;

    public CardResume() {
    }

    public CardResume(Long id, String name, String imageSmall) {
        this.id = id;
        this.name = name;
        this.imageSmall = imageSmall;
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

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }
}
