package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Card;

import com.revature.overcharge.beans.Card;







@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class CardServiceTests {

    @Autowired
    public CardService cs;
    

    @Test
    void addCardTest() {
        Card newCard1 = new Card(null, null, null);
        assertNotNull(cs.addCard(newCard1));
        Card newCard = new Card(1, null, null, null);
        assertThrows(ResponseStatusException.class, () -> {
            cs.addCard(newCard);
        });
		Card card = new Card("question", "answer", 87687687L);

		card = cs.addCard(card);
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
		card = cs.addCard(card);
		
		boolean ret = cs.deleteCard(card.getId());
		Assertions.assertTrue(ret);
    }

    @Test
    void getCardsByDeckIdTest() {
        assertFalse(true);
    }

}
