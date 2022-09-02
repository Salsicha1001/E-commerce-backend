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
public class CardsImagesDtoResponse {
    private Long id;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("image_url_small")
    private String imageUrlSmall;


}
