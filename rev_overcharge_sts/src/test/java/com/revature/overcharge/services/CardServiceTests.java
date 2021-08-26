package com.revature.overcharge.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.repositories.CardRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class CardServiceTests {

	@Autowired
	public CardService cs;
	@MockBean
	CardRepo cr;

	@Test
	void addCardTest() {
		// Card(String question, String answer, Long createdOn)
		// Card(int id, Deck deck, String question, String answer, Long createdOn)
		Deck deck = new Deck();
		// List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card("whats your name", "my name is ahmed", null);
		// Card(int id, Deck deck, String question, String answer, Long createdOn)
		Mockito.when(cr.save(card)).thenReturn(new Card(1, deck, "whats your name", "my name is ahmed", null));

		Assertions.assertEquals("whats your name", card.getQuestion());
	}

	@Test
	void getCardTest() {
		Deck deck = new Deck();
		List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card("whats your name", "my name is ahmed", null);

		Mockito.when(cr.save(card)).thenReturn(new Card(1, deck, "whats your name", "my name is ahmed", null));
		Assertions.assertEquals("my name is ahmed", card.getAnswer());
	}

	@Test
	void updateCardTest() {
		Deck deck = new Deck();
//		List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card("whats your lastName", "my name is Elhewazy", null);

		Mockito.when(cr.save(card)).thenReturn(new Card(1, deck, "whats your lastName", "my name is Elhewazy", null));
//		card = cs.updateCard(card);
		Assertions.assertEquals("whats your lastName", card.getQuestion());
		Assertions.assertEquals("my name is Elhewazy", card.getAnswer());
	}

	@Test
	void getCardsByDeckIdTest() {
		Deck deck = new Deck();
//		List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card(1, deck, "whats your name", "my name is ahmed", null);
		Mockito.when(cr.save(card)).thenReturn(new Card(1, deck, "whats your name", "my name is ahmed", null));
		// Card(int id, Deck deck, String question, String answer, Long
		// createdOn)(card);
		card = cs.addCard(0, card);
		// card = new Card(1, deck, "whats your name", "my name is ahmed", null);

		Assertions.assertEquals(1, card.getId());

	}

	@Test
	void deleteCardTest() {

		Deck deck = new Deck();
		List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();

		Card card = new Card("whats your name", "my name is ahmed", null);
		cr.save(card);
		cr.delete(card);

	}

}
