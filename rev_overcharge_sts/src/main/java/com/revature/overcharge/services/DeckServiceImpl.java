package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.exception.AlreadyApprovedException;
import com.revature.overcharge.exception.BadParameterException;
import com.revature.overcharge.repositories.DeckRepo;

@Service
public class DeckServiceImpl implements DeckService {

    private static final Logger log = Logger.getLogger(DeckServiceImpl.class);
    
    @Autowired
    DeckRepo dr;

    @Autowired
    CardService cs;

    @Autowired
    ObjectiveService os;

    @Autowired
    RatingService rs;

    @Override
    public Deck addDeck(Deck d) {
        if (dr.existsById(d.getId())) {
            log.warn("Deck id is invalid for add");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            d.setCreatedOn(new Date().getTime());
            d.setStatus(1);
            return dr.save(d);
        }
    }

    @Override
    public Deck getDeck(int id) {
        if (dr.existsById(id)) {
            return dr.findById(id).get();
        } else {
            log.warn("Deck id is not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Deck> getAllDecks() {
        List<Deck> decks = (List<Deck>) dr.findAll();
        for (Deck deck : decks) {
            deck.setAvgRating(rs.calculateAvgRating(deck.getId()));
        }
        return decks;
    }

    @Override
    public Deck updateDeck(Deck newDeck) {
        if (dr.existsById(newDeck.getId())) {
            Deck d = dr.findById(newDeck.getId()).get();
            d.setTitle(newDeck.getTitle());
            d.setStatus(1);
            return dr.save(d);
        } else {
            log.warn("Deck id is invalid for update");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean deleteDeck(int id) {
        // Cards have ON DELETE CASCADE for deleted Deck
        if (dr.existsById(id)) {
            dr.deleteById(id);
            return true;
        } else {
            log.warn("Deck id is invalid for delete");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Deck> getDecksByCreatorId(int creatorId) {
        if (dr.existsByCreatorId(creatorId)) {
            return dr.getByCreatorId(creatorId);
        } else {
//            log.warn("No deck found for given creator id");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Deck addDeckAndCards(Deck d) {
        if (dr.existsById(d.getId())) {
            log.warn("Deck id is invalid for add");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            Deck addedDeck = addDeck(d);

            for (Card c : d.getCards()) {
                addedDeck = getDeck(addedDeck.getId());
                c.setDeck(addedDeck);
                cs.addCard(addedDeck.getId(), c);
            }

            os.setCreateADeckWeekly(d.getCreator().getId());

            addedDeck = getDeck(addedDeck.getId());
            log.info(addedDeck);
            return addedDeck;
        }
    }

    @Override
    public Deck updateDeckAndCards(Deck newDeck) {
        if (dr.existsById(newDeck.getId())) {
            Deck d = dr.findById(newDeck.getId()).get();
            d.setTitle(newDeck.getTitle());
            for (Card c : d.getCards()) {
                for (Card c2 : newDeck.getCards()) {
                    if (c.getId() == c2.getId()) {
                        c.setQuestion(c2.getQuestion());
                        c.setAnswer(c2.getAnswer());
                    }
                }
            }
            return updateDeck(d);
        } else {
            log.warn("Deck id is invalid for update");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

	@Override
	public Deck deckApproval(int id, int status) throws BadParameterException, AlreadyApprovedException {
		
		if(status != 2 && status != 3) {
			throw new BadParameterException("Invalid input for deck status");
		}
		
		Deck d = dr.findById(id).get();
		
		if(d.getStatus() != 1) {
			throw new AlreadyApprovedException("You can't change the status of a deck that isn't pending");
		}
		
		d.setStatus(status);
		return d;
	}

}
