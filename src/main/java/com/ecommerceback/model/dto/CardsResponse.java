package com.ecommerceback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardsResponse {

    private List<CardsDtoResponse> data ;
    private PaginationApi meta;

}
