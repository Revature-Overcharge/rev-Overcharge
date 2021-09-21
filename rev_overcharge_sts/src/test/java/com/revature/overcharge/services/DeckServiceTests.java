package com.revature.overcharge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.CardRepo;
import com.revature.overcharge.repositories.DeckRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class DeckServiceTests {

	@Autowired
	public DeckService ds;
	@MockBean
	DeckRepo dr;
	@MockBean
	CardRepo cr;

	@Test
	@Transactional
	void addDeckTest() {
		// Deck( User creator, String title, Long createdOn, List<Card> cards)
		// User(String username, String password, Integer points, Long lastLogin)
//		int points = 100;
//		Integer point = (Integer) points;
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		Deck deck = new Deck(creator, "new deck", null, card, null, null);
		Deck mockDeck = new Deck(creator, "new page", null, card, null, null);
		mockDeck.setId(1);
		// Deck(int id, User creator, String title, Long createdOn, List<Card> cards)
		Mockito.when(dr.save(deck)).thenReturn(mockDeck);
		deck = ds.addDeck(deck);

		Assertions.assertEquals(1, deck.getId());
	}

	@Test
	@Transactional
	void addDeckTestFailure() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		Deck deck = new Deck(creator, "new deck", null, card, null, null);
		Mockito.when(dr.existsById(deck.getId())).thenReturn(true);

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			ds.addDeck(deck);
		});
	}

	@Test
	@Transactional
	void getAllDecksTest() {
		List<Deck> dList = new ArrayList<Deck>();
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck2", null, card, null, null);
		dList.add(deck);
		Mockito.when(dr.findAll()).thenReturn(dList);

		dList = ds.getAllDecks();

		Assertions.assertNotNull(dList);
	}

	@Test
	@Transactional
	void getDeckTest() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck2", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(true);
		Mockito.when(dr.findById(deck.getId())).thenReturn(Optional.of(deck).get());

		deck = ds.getDeck(deck.getId());

		Assertions.assertEquals("new deck2", deck.getTitle());
	}

	@Test
	@Transactional
	void getDeckTestFailure() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck2", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(false);

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			ds.getDeck(deck.getId());
		});
	}

	@Test
	@Transactional
	void updateDeckTest() {
//User creator, String title, Long createdOn, List<Card> cards
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));

		Deck deck = new Deck( creator, "new deck3", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(true);
		Mockito.when(dr.findById(deck.getId())).thenReturn(Optional.of(deck).get());
		Mockito.when(dr.save(deck)).thenReturn(new Deck( creator, "new deck3", null, card, null, null));

		deck = ds.updateDeck(deck);

		Assertions.assertEquals("new deck3", deck.getTitle());
	}

	@Test
	@Transactional
	void updateDeckTestFailure() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));

		Deck deck = new Deck(creator, "new deck3", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(false);

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			ds.updateDeck(deck);
		});
	}

	@Test
	@Transactional
	void deleteDeckTest() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(true);
		Assertions.assertEquals(ds.deleteDeck(deck.getId()), true);
	}

	@Test
	@Transactional
	void deleteDeckFailure() {
		User creator = new User("ahmed", "pass", null, 0, null);
		List<Card> card = new ArrayList<Card>();
		card.add(new Card("whats your name", "my name is ahmed", null));
		Deck deck = new Deck(creator, "new deck", null, card, null, null);

		Mockito.when(dr.existsById(deck.getId())).thenReturn(false);
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			ds.deleteDeck(deck.getId());
		});
	}

// 	@Test
// 	void findByCreatorIdTest() {
// 		List<Deck> dList = new ArrayList<Deck>();
// 		User creator = new User(1, "ahmed", "pass", null, null);
// 		List<Card> card = new ArrayList<Card>();
// 		card.add(new Card("whats your name", "my name is ahmed", null));
// 		Deck deck = new Deck(creator, "new deck2", null, card);
// 		dList.add(deck);
// 		// Mockito.when(dr.findByCreatorId(creator.getId())).thenReturn(dList);

// 		dList = ds.getDecksByCreatorId(creator.getId());

// 		Assertions.assertNotNull(dList);
// 	}

// 	@Test
// 	void addDeckandCardsTest() {
// 		User creator = new User(11, null, null, null, null);
// 		List<Card> cards = new ArrayList<Card>();
// 		cards.add(new Card("whats your name", "my name is ahmed", null));
// 		cards.add(new Card("EUGH", "BLAUGH", null));
// 		Deck deck = new Deck(creator, "new deck2", null, cards);

// 		deck = ds.addDeckAndCards(deck);
// 	}

}
