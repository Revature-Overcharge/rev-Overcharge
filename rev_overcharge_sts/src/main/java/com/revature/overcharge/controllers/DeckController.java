package com.revature.overcharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.services.DeckService;

@CrossOrigin
@RestController
public class DeckController {

    @Autowired
    DeckService ds;
    @CrossOrigin
    @PostMapping(value = "/decks", consumes = "application/json",
            produces = "application/json")
    public Deck addDeck(@RequestBody Deck d) {
        return ds.addDeckAndCards(d);
    }

    @CrossOrigin
    @GetMapping(value = "/decks/{id}")
    public Deck getDeck(@PathVariable("id") int id) {
        return ds.getDeck(id);
    }

    @CrossOrigin
    @GetMapping(value = "/decks")
    public List<Deck> getAllDecks() {
        return ds.getAllDecks();
    }

    // If wanting to only update the deck title, expecting a lighter JSON in
    // body
    @CrossOrigin
    @PutMapping(value = "/decks/{id}", consumes = "application/json",
            produces = "application/json")
    public Deck updateDeck(@PathVariable int id, @RequestBody Deck newDeck) {
        newDeck.setId(id);
        return ds.updateDeck(newDeck);
    }

    // If wanting to update deck title as well as cards, expecting a more full
    // JSON in body
    @CrossOrigin
    @PutMapping(value = "/decks/{id}/cards", consumes = "application/json",
            produces = "application/json")
    public Deck updateDeckAndCards(@PathVariable int id,
            @RequestBody Deck newDeck) {
        newDeck.setId(id);
        return ds.updateDeckAndCards(newDeck);
    }

    @CrossOrigin
    @DeleteMapping(value = "/decks/{id}")
    public boolean deleteDeck(@PathVariable("id") int id) {
        return ds.deleteDeck(id);
    }

}
