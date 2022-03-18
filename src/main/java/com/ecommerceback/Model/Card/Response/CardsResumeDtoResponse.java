package com.ecommerceback.Model.Card.Response;

import com.ecommerceback.Model.Util.PaginationApi;

import java.util.ArrayList;
import java.util.List;

public class CardsResumeDtoResponse {
    private List<CardResume> data = new ArrayList<>();
    private PaginationApi meta;

    public CardsResumeDtoResponse() {
    }

    public CardsResumeDtoResponse(List<CardResume> data, PaginationApi meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<CardResume> getData() {
        return data;
    }

    public void setData(List<CardResume> data) {
        this.data = data;
    }

    public PaginationApi getMeta() {
        return meta;
    }

    public void setMeta(PaginationApi meta) {
        this.meta = meta;
    }
}
