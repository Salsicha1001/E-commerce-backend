package com.ecommerceback.Model.User.Request;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class OrdersDtoRequest {
    private Long id_user;
    private List<OrderListDto>listOrders= new ArrayList<OrderListDto>();

    public OrdersDtoRequest() {
    }

    public OrdersDtoRequest(Long id_user, List<OrderListDto> listOrders) {
        this.id_user = id_user;
        this.listOrders = listOrders;
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
}
