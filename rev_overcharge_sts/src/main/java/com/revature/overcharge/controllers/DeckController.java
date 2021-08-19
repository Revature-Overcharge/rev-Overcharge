package com.revature.overcharge.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.services.CardService;
import com.revature.overcharge.services.DeckService;


@CrossOrigin
@RestController
public class DeckController {

    @Autowired
    DeckService ds;
    @Autowired
    CardService cs;

    @GetMapping(value = "/decks/{id}")
    public Deck getDeck(@PathVariable("id") String id) {
        return ds.getDeck(Integer.parseInt(id));
    }
    
    @GetMapping(value = "/decks")
    public List<Deck> getAllDecks(){
    	return ds.getAllDecks();
    }

    @PostMapping(value = "/decks", consumes = "application/json",
            produces = "application/json")
    public Deck addDeck(@RequestBody Deck d) {

    	d.setCreatedOn(new Date().getTime());
    	Deck saveDeck = ds.addDeck(d);
    	int size = d.getCards().size();
    	
    	for (int i=0;i<size;i++) {
    		Card card = d.getCards().get(i);
    		card.setDeck(saveDeck);
    		card = cs.updateCard(card);
    	}
    	
        return saveDeck;
        
    }

    @PutMapping(value = "/decks/{id}", consumes = "application/json",
            produces = "application/json")
    public Deck updateDeck(@PathVariable int id, @RequestBody Deck newDeck) {
        newDeck.setId(id);
        return ds.updateDeck(newDeck);
    }

}
