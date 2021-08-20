package com.revature.overcharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.services.CardService;

@CrossOrigin
@RestController
public class CardController {

    @Autowired
    CardService cs;

    @GetMapping(value = "/cards/{id}")
    public Card getCard(@PathVariable("id") String id) {
        return cs.getCard(Integer.parseInt(id));
    }
    
    @GetMapping(value = "/decks/{id}/cards")
    public List<Card> getCardsByDeckId(@PathVariable("id") String id){
        return cs.getCardsByDeckId(Integer.parseInt(id));
    }

}
