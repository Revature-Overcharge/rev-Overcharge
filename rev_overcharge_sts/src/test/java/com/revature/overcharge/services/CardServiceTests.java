package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.test.annotation.DirtiesContext.ClassMode;


import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.repositories.CardRepo;

@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class CardServiceTests {

	@Autowired
	public CardService cs;
	@MockBean
	CardRepo cr;

	@Test
	@Transactional
	void addCardTest() {
		// Card(String question, String answer, Long createdOn)
		// Card(int id, Deck deck, String question, String answer, Long createdOn)
		Deck deck = new Deck();
		// List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card("whats your name", "my name is ahmed", null);
		// Card(int id, Deck deck, String question, String answer, Long createdOn)
		Mockito.when(cr.save(card)).thenReturn(new Card(1, deck, "whats your name", "my name is ahmed", null));

		card = cs.addCard(1, card);
		
		Assertions.assertEquals("whats your name", card.getQuestion());
	}
	
	@Test
	@Transactional
	void addCardFailure() {
		Deck deck = new Deck();
		Card card = new Card("whats your name", "my name is ahmed", null);
		Mockito.when(cr.existsById(card.getId())).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> {
            cs.addCard(1, card);
        });
	}

	@Test
	@Transactional
	void getCardTest() {
		Deck deck = new Deck();
		Card card = new Card(1, "whats your name", "my name is ahmed", null);

		Mockito.when(cr.existsById(card.getId())).thenReturn(true);
		Mockito.when(cr.findById(card.getId())).thenReturn(Optional.of(card));;
		
		cs.getCard(card.getId());
		
		Assertions.assertEquals("my name is ahmed", card.getAnswer());
	}
	
	@Test
	@Transactional
	void getCardFailure() {
		Deck deck = new Deck();
		Card card = new Card(1, "whats your name", "my name is ahmed", null);
		
		Mockito.when(cr.existsById(card.getId())).thenReturn(false);
		
        assertThrows(ResponseStatusException.class, () -> {
            cs.getCard(card.getId());
        });
	}

	@Test
	@Transactional
	void updateCardTest() {

//		List<StudiedCard> studiedCards = new ArrayList<StudiedCard>();
		Card card = new Card(1, null, "whats your lastNameAH", "my name is Elhewazy", null);
		
		Mockito.when(cr.existsById(card.getId())).thenReturn(true);
		Mockito.when(cr.save(card)).thenReturn(new Card(1, null, "whats your lastName", "my name is Elhewazy", null));
		card = cs.updateCard(1, card);
		Assertions.assertEquals("whats your lastName", card.getQuestion());
		Assertions.assertEquals("my name is Elhewazy", card.getAnswer());
	}
	
	@Test
	@Transactional
	void updateCardFailure() {
		Card card = new Card(1, null, "whats your lastNameAH", "my name is Elhewazy", null);
		
		Mockito.when(cr.existsById(card.getId())).thenReturn(false);
        assertThrows(ResponseStatusException.class, () -> {
            cs.updateCard(0, card);
        });
	}

	@Test
	@Transactional
	void deleteCardTest() {
		Deck deck = new Deck();
		Card card = new Card(1, "whats your name", "my name is ahmed", null);

		Mockito.when(cr.existsById(card.getId())).thenReturn(true);
		
		Assertions.assertEquals(cs.deleteCard(card.getId()), true);
	}
	
	@Test
	@Transactional
	void deleteCardFailure() {
		Deck deck = new Deck();
		Card card = new Card(1, "whats your name", "my name is ahmed", null);

		Mockito.when(cr.existsById(card.getId())).thenReturn(false);
		
        assertThrows(ResponseStatusException.class, () -> {
            cs.deleteCard(card.getId());
        });
	}
	
	@Test
	@Transactional
	void getAllCardsTest() {
		Deck deck = new Deck();
		Card card = new Card(1, "whats your name", "my name is ahmed", null);
		List<Card> cList = new ArrayList<Card>();
		cList.add(card);
		
		Mockito.when(cr.findAll()).thenReturn(cList);
		
		Assertions.assertNotNull(cList);
	}

}