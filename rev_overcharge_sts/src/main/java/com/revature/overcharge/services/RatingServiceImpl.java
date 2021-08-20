package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

	private static final Logger log = Logger.getLogger(RatingServiceImpl.class);

	@Autowired
	RatingRepo rr;
	@Autowired
	UserService us;
	@Autowired
	DeckService ds;

	@Override
	public Rating addRating(Rating r) {
		if (rr.existsById(r.getUser().getId()) && rr.existsById(r.getDeck().getId())) {
			log.warn("id is invalid for add");
			return null;
		} else {
			return rr.save(r);
		}
	}

	@Override
	public Rating getRatingByUserIdAndDeckId(int userId, int deckId) {
		User u;
		Deck d;
		
		u = us.getUser(userId);
		d = ds.getDeck(deckId);
		
		return rr.findByUserAndDeck(u, d);
	}

	@Override
	public Rating updateRating(Rating newRating) {
		if (rr.existsById(newRating.getUser().getId()) && rr.existsById(newRating.getDeck().getId())) {
			return rr.save(newRating);
		} else {
			log.warn("id is invalid for update");
			return null;
		}
	}

	@Override
	public boolean deleteRatingByUserIdAndDeckId(int userId, int deckId) {
		try {
			User u;
			Deck d;
			
			u = us.getUser(userId);
			d = ds.getDeck(deckId);
			
			rr.delete(rr.findByUserAndDeck(u, d));
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Rating> getRatingsByUserId(int userId) {
		User u;
		
		u = us.getUser(userId);
		
		return rr.findByUser(u);
	}

	@Override
	public List<Rating> getRatingsByDeckId(int deckId) {
		Deck d;
		
		d = ds.getDeck(deckId);
		
		return rr.findByDeck(d);
	}

}
