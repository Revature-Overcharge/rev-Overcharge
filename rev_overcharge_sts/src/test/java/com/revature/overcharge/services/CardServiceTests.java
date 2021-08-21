package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    }

    @Test
    void getCardTest() {
        assertFalse(true);
    }

    @Test
    void updateCardTest() {
        assertFalse(true);
    }

    @Test
    void deleteCardTest() {
        assertFalse(true);
    }

    @Test
    void getCardsByDeckIdTest() {
        assertFalse(true);
    }

}
