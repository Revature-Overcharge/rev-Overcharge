package com.revature.overcharge.controllers;

import java.util.List;

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
    public Card getCard(@PathVariable("id") int id) {
        return cs.getCard(id);
    }

    @GetMapping(value = "/decks/{id}/cards")
    public List<Card> getCardsByDeckId(@PathVariable("id") int id) {
        return cs.getCardsByDeckId(id);
    }

    @PostMapping(value = "/cards", consumes = "application/json",
            produces = "application/json")
    public Card addCard(@RequestBody Card c) {
        return cs.addCard(c);
    }

    @GetMapping(value = "/cards")
    public List<Card> getAllCards() {
        return cs.getAllCards();
    }

}
