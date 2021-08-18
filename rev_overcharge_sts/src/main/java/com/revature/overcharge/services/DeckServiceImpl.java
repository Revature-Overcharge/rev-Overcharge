package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.repositories.DeckRepo;

@Service
public class DeckServiceImpl implements DeckService {

    private static final Logger log = Logger.getLogger(DeckServiceImpl.class);

    @Autowired
    DeckRepo dr;

    @Override
    public Deck addDeck(Deck d) {
        if (dr.existsById(d.getId())) {
            log.warn("Deck id is invalid for add");
            return null;
        } else {
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
            return dr.save(newDeck);
        } else {
            log.warn("Deck id is invalid for update");
            return null;
        }
    }

    @Override
    public boolean deleteDeck(int id) {
        try {
            dr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }

    @Override
    public List<Deck> getDecksByCreatorId(int creatorId) {
        return dr.findByCreatorId(creatorId);
    }

}
