package com.ecommerceback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResumeResponse {

    private Long id;
    private String name;
    private String imageSmall;
    private String archetype;

}
