package com.revature.overcharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
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
    
    @PostMapping(value = "/cards", consumes = "application/json",
            produces = "application/json")
    public Card addCard(@RequestBody Card c) {
        return cs.addCard(c);
    }

}
