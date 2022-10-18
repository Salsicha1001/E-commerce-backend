package com.ecommerceback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerceback.service.impl.CardServiceImpl;

@RestController
@CrossOrigin(origins = "https://cards.marcelogonzaga.dev.br")
@RequestMapping("/cards")
public class CardsController {
    @Autowired
    private CardServiceImpl cardService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards( @RequestParam(value="page", defaultValue="1") Integer offset,
                                                               @RequestParam(value="linesPerPage", defaultValue="24") Integer num,
                                                               @RequestParam(value="language", defaultValue="") String language){
        return cardService.getAllCardsPage(offset,num,language);

    }
    @GetMapping("/getByName")
    public ResponseEntity<?> getCardByName(@RequestParam(value="name", defaultValue="") String name,
                                           @RequestParam(value="language", defaultValue="") String language){
    return cardService.getCardByName(language,name);
    }
    @GetMapping("/search")
    public ResponseEntity<?> getSearchCards( @RequestParam(value="page", defaultValue="0") Integer offset,
                                          @RequestParam(value="linesPerPage", defaultValue="500") Integer num,
                                          @RequestParam(value="language", defaultValue="") String language,
                                          @RequestParam(value="race", defaultValue="") String race,
                                          @RequestParam(value="type", defaultValue="") String type,
                                          @RequestParam(value="archetype", defaultValue="") String archetype,
                                          @RequestParam(value="attribute", defaultValue="") String attribute,
                                          @RequestParam(value="level", defaultValue="") String level,
                                          @RequestParam(value="fname", defaultValue="") String fname,//Pt se language for pt
                                          @RequestParam(value="def", defaultValue="") String def,
                                          @RequestParam(value="atk", defaultValue="") String atk){
        return cardService.getSearchCard(offset,num,language,race,type,archetype,attribute,level,fname,def,atk);
    }
    @GetMapping("/getByArchetype")
    public ResponseEntity<?> getCardByArtype(@RequestParam(value="archetype", defaultValue="") String archetype,
                                           @RequestParam(value="language", defaultValue="") String language){
        return cardService.getAllCardsArctype(archetype,language);
    }
}
