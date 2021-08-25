package com.revature.overcharge.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.DeckRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)

public class DeckServiceTests {

	@Autowired
	public DeckService ds;
	@MockBean
	DeckRepo dr;

	@Test
	void addDeckTest() {
		// Deck( User creator, String title, Long createdOn, List<Card> cards)
		// User(String username, String password, Integer points, Long lastLogin)
//		int points = 100;
//		Integer point = (Integer) points;
		User creator = new User("ahmed", "pass", null, null);
		List<Card> card = new ArrayList<Card>();
		Deck deck = new Deck(creator, "new deck", null, card);
		// Deck(int id, User creator, String title, Long createdOn, List<Card> cards)
		Mockito.when(dr.save(deck)).thenReturn(new Deck(1, creator, "new page", null, card));
		deck = ds.addDeck(deck);

		Assertions.assertEquals(1, deck.getId());
	}

	@Test
	void getDeckTest() {
		User creator = new User("ahmed", "pass", null, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck2", null, card);
//		Optional<Deck> option1 = Optional.of(deck);
//		deck = ds.addDeck(deck);
		Mockito.when(dr.save(deck)).thenReturn(new Deck(2, creator, "new deck2", null, card));

		// Deck(int id, User creator, String title, Long createdOn, List<Card> cards)
		Assertions.assertEquals("new deck2", deck.getTitle());

	}

	@Test
	void updateDeckTest() {
//User creator, String title, Long createdOn, List<Card> cards
		User creator = new User("ahmed", "pass", null, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));

		Deck deck = new Deck(creator, "new deck3", null, card);

		Mockito.when(dr.save(deck)).thenReturn(new Deck(1, creator, "new deck3", null, card));

		Assertions.assertEquals("new deck3", deck.getTitle());
	}

	@Test
	void deleteDeckTest() {
		User creator = new User("ahmed", "pass", null, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck", null, card);

		dr.save(deck);
		dr.delete(deck);

	}

//	@Test
//	void getDecksByCreatorIdTest() {
//		assertFalse(true);
//	}

}
