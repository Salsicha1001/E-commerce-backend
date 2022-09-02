package com.ecommerceback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardSetsDtoResponse {
    @JsonProperty("set_name")
    private String set_name;
    @JsonProperty("set_code")
    private String set_code;
    @JsonProperty("set_rarity")
    private String set_rarity;
    @JsonProperty("set_rarity_code")
    private String setRarityCode;
    @JsonProperty("set_price")
    private String setPrice;


}
