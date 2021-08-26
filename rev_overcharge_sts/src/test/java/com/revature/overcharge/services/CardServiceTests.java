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

<<<<<<< HEAD
	}
=======
    @Autowired
    public CardService cs;
    

    @Test
    void addCardTest() {
        Card newCard1 = new Card(null, null, null);
        assertNotNull(cs.addCard(0, newCard1));
        Card newCard = new Card(1, null, null, null);
        assertThrows(ResponseStatusException.class, () -> {
            cs.addCard(0, newCard);
        });
		Card card = new Card("question", "answer", 87687687L);

		card = cs.addCard(0, card);
		System.out.println(card);
				
		Assertions.assertNotEquals(0, card.getId());
		Assertions.assertEquals("question", card.getQuestion());
    }

    @Test
    void getCardTest() {
		Card card = new Card(1, "question", "answer", 8796986L);
		Optional<Card> optionI = Optional.of(card);
	
			
		Assertions.assertEquals(1, optionI.get().getId());
    }

    @Test
    void updateCardTest() {
		Card card = new Card(1, "question", "answer", 987987L);
		
		card = cs.updateCard(card);
		Assertions.assertEquals(1, card.getId());
		Assertions.assertEquals("question", card.getQuestion());
    }

    @Test
    void deleteCardTest() {
		Card card = new Card("question", "answer", 987987L);
		card = cs.addCard(0, card);
		
		boolean ret = cs.deleteCard(card.getId());
		Assertions.assertTrue(ret);
    }

    @Test
    void getCardsByDeckIdTest() {
        assertFalse(true);
    }
>>>>>>> origin/main

}

