package com.revature.overcharge.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.exception.AlreadyApprovedException;
import com.revature.overcharge.exception.BadParameterException;
import com.revature.overcharge.services.DeckService;

@CrossOrigin
@RestController
public class DeckController {

	@Autowired
	DeckService ds;

	@Autowired
	private HttpServletRequest request;

	@PostMapping(value = "/decks", consumes = "application/json", produces = "application/json")
	public Deck addDeck(@RequestBody Deck d) {
		return ds.addDeckAndCards(d);
	}

	@GetMapping(value = "/decks/{id}")
	public Deck getDeck(@PathVariable("id") int id) {
		return ds.getDeck(id);
	}

	@GetMapping(value = "/decks")
	public List<Deck> getAllDecks() {
		return ds.getAllDecks();
	}

	// If wanting to only update the deck title, expecting a lighter JSON in
	// body
	@PutMapping(value = "/decks/{id}", consumes = "application/json", produces = "application/json")
	public Deck updateDeck(@PathVariable int id, @RequestBody Deck newDeck) {
		newDeck.setId(id);
		return ds.updateDeck(newDeck);
	}

	// If wanting to update deck title as well as cards, expecting a more full
	// JSON in body
	@PutMapping(value = "/decks/{id}/cards", consumes = "application/json", produces = "application/json")
	public Deck updateDeckAndCards(@PathVariable int id, @RequestBody Deck newDeck) {
		newDeck.setId(id);
		return ds.updateDeckAndCards(newDeck);
	}

	@PatchMapping(value = "/decks/{id}/{status}", produces = "application/json" )
	public ResponseEntity<Object> deckApproval(@PathVariable int id, @PathVariable int status) {

		try {
			HttpSession session = request.getSession(false);

			User user = (User) session.getAttribute("currentUser");

			if (session == null || user.getRole() != 1) {
				return ResponseEntity.status(400).body("You are not an admin!");
			}
			
			Deck updatedDeck = ds.deckApproval(id, status);


			return ResponseEntity.status(201).body(updatedDeck);
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		} catch (AlreadyApprovedException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}


	}

	@DeleteMapping(value = "/decks/{id}")
	public boolean deleteDeck(@PathVariable("id") int id) {
		return ds.deleteDeck(id);
	}

}
