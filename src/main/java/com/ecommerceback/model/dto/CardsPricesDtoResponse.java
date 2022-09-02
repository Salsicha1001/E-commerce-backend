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
public class CardsPricesDtoResponse {
    @JsonProperty("cardmarket_price")
    private String cardMarketPrice;
    @JsonProperty("tcgplayer_price")
    private String tcgPlayerPrice;
    @JsonProperty("ebay_price")
    private String ebayPrice;
    @JsonProperty("amazon_price")
    private String amazonPrice;
    @JsonProperty("coolstuffinc_price")
    private String coolStuffincPrice;

}
