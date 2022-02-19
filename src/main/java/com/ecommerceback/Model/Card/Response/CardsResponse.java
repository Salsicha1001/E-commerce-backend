package com.ecommerceback.Model.Card.Response;

import com.ecommerceback.Model.Util.PaginationApi;

import java.util.ArrayList;
import java.util.List;

public class CardsResponse {

    private List<CardsDtoResponse> data = new ArrayList<>();
    private PaginationApi meta;
    public CardsResponse() {
    }

    public CardsResponse(List<CardsDtoResponse> data, PaginationApi meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<CardsDtoResponse> getData() {
        return data;
    }

    public void setData(List<CardsDtoResponse> data) {
        this.data = data;
    }

    public PaginationApi getMeta() {
        return meta;
    }

    public void setMeta(PaginationApi meta) {
        this.meta = meta;
    }
}
