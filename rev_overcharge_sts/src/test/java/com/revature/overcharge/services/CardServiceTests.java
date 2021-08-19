package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class CardServiceTests {
    
    @Autowired
    public CardService cs;
    
    @Test
    void addCardTest() {
        assertFalse(true);
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
