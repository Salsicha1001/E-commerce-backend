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
public class CardsResumeDtoResponse {
    private List<CardResumeResponse> data = new ArrayList<>();
    private PaginationApi meta;

}
