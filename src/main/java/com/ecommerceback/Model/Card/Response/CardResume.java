package com.ecommerceback.Model.Card.Response;

import java.util.ArrayList;
import java.util.List;

public class CardResume {

    private Long id;
    private String name;
    private String imageSmall;
    private String archetype;

    public CardResume() {
    }

    public CardResume(Long id, String name, String imageSmall, String archetype) {
        this.id = id;
        this.name = name;
        this.imageSmall = imageSmall;
        this.archetype = archetype;
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

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }
}
