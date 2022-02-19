package com.ecommerceback.Controller.Cards;

import com.ecommerceback.Model.Card.Response.CardsDtoResponse;
import com.ecommerceback.Service.Cards.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsController {
    @Autowired
    private CardService cardService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards( @RequestParam(value="page", defaultValue="1") Integer offset,
                                                               @RequestParam(value="linesPerPage", defaultValue="24") Integer num,
                                                               @RequestParam(value="orderBy", defaultValue="name") String orderBy,
                                                               @RequestParam(value="language", defaultValue="") String language){
        return cardService.getAllCardsPage(offset,num,orderBy,language);

    }
}
