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

	@GetMapping(value = "/decks/{id}")
	public Deck getDeck(@PathVariable("id") String id) {
		return ds.getDeck(Integer.parseInt(id));
	}
	
	@PostMapping(value = "/decks", consumes = "application/json", produces = "application/json")
	public Deck addDeck(@RequestBody Deck d){
		return ds.addDeck(d);
	}
	
	@PutMapping(value = "/orders/{id}", consumes = "application/json", produces = "application/json")
	public Deck updateDeck(@PathVariable int id, @RequestBody Deck newDeck) {
		newDeck.setId(id);
		return ds.updateDeck(newDeck);
	}
	
}
