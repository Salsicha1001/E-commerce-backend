package com.ecommerceback.Model.Card.Response;

public class CardsImagesDtoResponse {
    private Long id;
    private String image_url;
    private String image_url_small;

    public CardsImagesDtoResponse() {
    }

    public CardsImagesDtoResponse(Long id, String image_url, String image_url_small) {
        this.id = id;
        this.image_url = image_url;
        this.image_url_small = image_url_small;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url_small() {
        return image_url_small;
    }

    public void setImage_url_small(String image_url_small) {
        this.image_url_small = image_url_small;
    }
}
