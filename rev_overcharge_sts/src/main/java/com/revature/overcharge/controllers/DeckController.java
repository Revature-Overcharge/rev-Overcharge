package com.revature.overcharge.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.dto.DeckTagsDTO;
import com.revature.overcharge.exception.AlreadyApprovedException;
import com.revature.overcharge.exception.BadParameterException;
import com.revature.overcharge.services.DeckService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class DeckController {
	private static final Logger log = LoggerFactory.getLogger(DeckController.class);

	
	
	@Autowired
	DeckService ds;

	@Autowired
	private HttpServletRequest request;
	
	@PutMapping(path = "/setDeckTags/{id}", produces = "application/json")
	public ResponseEntity<Object> setDeckTags(@PathVariable("id") int id,@RequestBody DeckTagsDTO deckTagsDTO) {
		System.out.println("Set Deck Tags Request Recieved...");
		Deck deck =ds.setDeckTags(id, deckTagsDTO);
		
		return ResponseEntity.status(200).body("it worked");
		
	}	

	@PostMapping(value = "/decks", consumes = "application/json", produces = "application/json")
	public Deck addDeck(@RequestBody Deck d) {
		return ds.addDeckAndCards(d);
	}

	@GetMapping(value = "/decks/{id}")
    public Deck getDeck(@PathVariable("id") int id) {
    	log.trace("getDeck(): id: ["+ id + "]");
    	Deck objRetDeck = ds.getDeck(id);
    	log.trace("getDeck(): objRetDeck: ["+ objRetDeck.toString() + "]");
    	
        return objRetDeck;
    }

	@GetMapping(value = "/decks")
	public List<Deck> getAllDecks() {
		return ds.getAllDecks();
	}

	@GetMapping(path ="/decksByTag", produces = "application/json")
    public ResponseEntity<Object> getDecksByTagId(@RequestParam(name="tagId") int tagId){
    	return ResponseEntity.status(200).body(ds.getDecksByTagId(tagId));
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
