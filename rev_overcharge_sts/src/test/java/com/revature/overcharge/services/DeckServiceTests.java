package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class DeckServiceTests {

    @Autowired
    public DeckService ds;

    @Test
    void addDeckTest() {
        assertFalse(true);
    }

    @Test
    void getDeckTest() {
        assertFalse(true);
    }

    @Test
    void updateDeckTest() {
        assertFalse(true);
    }

    @Test
    void deleteDeckTest() {
        assertFalse(true);
    }

    @Test
    void getDecksByCreatorIdTest() {
        assertFalse(true);
    }

}
