package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.repositories.CardRepo;

@Service
public class CardServiceImpl implements CardService {

    private static final Logger log = Logger.getLogger(CardServiceImpl.class);

    @Autowired
    CardRepo cr;
    
    @Autowired
    ObjectiveService os;

    @Override
    public Card addCard(Card c) {
        if (cr.existsById(c.getId())) {
            log.warn("Card id is invalid for add");
            return null;
        } else {
            c.setCreatedOn(new Date().getTime());
            os.addCardObj(c);
            return cr.save(c);
        }
    }

    @Override
    public Card getCard(int id) {
        try {
            return cr.findById(id).get();
        } catch (Exception e) {
            log.warn(e);
            return null;
        }
    }

    @Override
    public Card updateCard(Card newCard) {
        if (cr.existsById(newCard.getId())) {
            return cr.save(newCard);
        } else {
            log.warn("Card id is invalid for update");
            return null;
        }
    }

    @Override
    public boolean deleteCard(int id) {
        try {
            cr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }

    @Override
    public List<Card> getCardsByDeckId(int deckId) {
        return cr.findByDeckId(deckId);
    }

}
