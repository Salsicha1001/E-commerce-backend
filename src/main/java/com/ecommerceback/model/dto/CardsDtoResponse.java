package com.ecommerceback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardsDtoResponse {
    private Long id;
    private String name;
    private String type;
    private String desc;
    private String race;
    private String archetype;
    private long atk;
    private long def;
    private long level;
    private String attribute;
    @JsonProperty("linkval")
    private long linkVal;
    @JsonProperty("linkmarkers")
    private List<String> linkMarkers;
    private long scale;
    @JsonProperty("card_sets")
    private List<CardSetsDtoResponse> cardSets ;
    @JsonProperty("card_images")
    private List<CardsImagesDtoResponse> cardImages;
    @JsonProperty("card_prices")
    private List<CardsPricesDtoResponse> cardPrices;

}
