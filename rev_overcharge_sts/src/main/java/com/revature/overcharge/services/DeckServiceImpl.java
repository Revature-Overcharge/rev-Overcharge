package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.repositories.DeckRepo;

@Service
public class DeckServiceImpl implements DeckService {

    private static final Logger log = Logger.getLogger(DeckServiceImpl.class);

    @Autowired
    DeckRepo dr;

    @Autowired
    CardService cs;

    @Override
    public Deck addDeck(Deck d) {
        if (dr.existsById(d.getId())) {
            log.warn("Deck id is invalid for add");
            return null;
        } else {
            // Add cards and deck
            for (Card c : d.getCards()) {
                cs.addCard(c);
            }
            return dr.save(d);
        }
    }

    @Override
    public Deck getDeck(int id) {
        try {
            return dr.findById(id).get();
        } catch (Exception e) {
            log.warn(e);
            return null;
        }
    }

    @Override
    public Deck updateDeck(Deck newDeck) {
        if (dr.existsById(newDeck.getId())) {
            // Delete old cards and deck before adding new cards and deck
            deleteDeck(newDeck.getId());
            return addDeck(newDeck);
        } else {
            log.warn("Deck id is invalid for update");
            return null;
        }
    }

    @Override
    public boolean deleteDeck(int id) {
        if (dr.existsById(id)) {
            // Delete cards and deck
            for (Card c : cs.getCardsByDeckId(id)) {
                cs.deleteCard(c.getId());
            }
            dr.deleteById(id);
            return true;
        } else {
            log.warn("Deck id is invalid for delete");
            return false;
        }
    }

    @Override
    public List<Deck> getDecksByCreatorId(int creatorId) {
        return dr.findByCreatorId(creatorId);
    }

}
