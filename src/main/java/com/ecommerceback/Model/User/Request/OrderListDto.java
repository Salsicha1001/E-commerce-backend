package com.ecommerceback.Model.User.Request;

public class OrderListDto {

    private String id_card;
    private String name_card;
    private String img_url;
    private String price;
    private String qty;

    public OrderListDto() {
    }

    public OrderListDto(String id_card, String name_card, String img_url, String price, String qty) {
        this.id_card = id_card;
        this.name_card = name_card;
        this.img_url = img_url;
        this.price = price;
        this.qty = qty;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getName_card() {
        return name_card;
    }

    public void setName_card(String name_card) {
        this.name_card = name_card;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
