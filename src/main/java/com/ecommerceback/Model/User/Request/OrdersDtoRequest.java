package com.ecommerceback.Model.User.Request;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class OrdersDtoRequest {
    private Long id_user;
    private List<OrderListDto>listOrders= new ArrayList<OrderListDto>();
    private Long id_credCard;

    public OrdersDtoRequest() {
    }

    public OrdersDtoRequest(Long id_user, List<OrderListDto> listOrders, Long id_credCard) {
        this.id_user = id_user;
        this.listOrders = listOrders;
        this.id_credCard = id_credCard;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public List<OrderListDto> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<OrderListDto> listOrders) {
        this.listOrders = listOrders;
    }

    public Long getId_credCard() {
        return id_credCard;
    }

    public void setId_credCard(Long id_credCard) {
        this.id_credCard = id_credCard;
    }
}
