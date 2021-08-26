package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;


@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class DeckServiceTests {

    @Autowired
    public DeckService ds;

    @Test
    void addDeckTestPass() {
		Deck deck = new Deck(null, "test deck", 982374983L, null);

		deck = ds.addDeck(deck);
		System.out.println(deck);
				
		Assertions.assertNotEquals(0, deck.getId());
		Assertions.assertEquals("test deck", deck.getTitle());
    }

    @Test
    void getDeckTest() {
		Deck deck = new Deck(1, null, "test deck", 982374983L, null);
		Optional<Deck> optionI = Optional.of(deck);
	
			
		Assertions.assertEquals(1, optionI.get().getId());
    }

    @Test
    void updateDeckTest() {
		Deck deck = new Deck(1, null, "test deck", 982374983L, null);
		
		deck = ds.updateDeck(deck);
		Assertions.assertEquals(1, deck.getId());
		Assertions.assertEquals("test deck", deck.getTitle());
    }

    @Test
    void deleteDeckTest() {
		Deck deck = new Deck(null, "test deck", 982374983L, null);
		deck = ds.addDeck(deck);
		
		boolean ret = ds.deleteDeck(deck.getId());
		Assertions.assertTrue(ret);
    }

    @Test
    void getDecksByCreatorIdTest() {
        assertFalse(true);
    }

}
