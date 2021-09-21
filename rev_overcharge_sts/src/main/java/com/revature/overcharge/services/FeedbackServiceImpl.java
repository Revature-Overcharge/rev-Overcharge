package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Feedback;
import com.revature.overcharge.repositories.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private static final Logger log = LoggerFactory.getLogger(Feedback.class);

	@Autowired
	FeedbackRepo fr;

	@Autowired
	DeckService ds;

	@Override
	public Feedback addFeedback(int deckId, Feedback f) {
		if (fr.existsById(f.getId())) {
			log.warn("Card id is invalid for add");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} else {
			f.setDeck(ds.getDeck(deckId));
			f.setCreatedOn(new Date().getTime());
			f = fr.save(f);
			return f;
		}
	}

	@Override
	public Feedback getFeedback(int id) {
		if (fr.existsById(id)) {
			return fr.findById(id).get();
		} else {
			log.warn("Feedback id is not found");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Feedback updateFeedback(Feedback newFeedback) {
		if (fr.existsById(newFeedback.getId())) {
			return fr.save(newFeedback);
		} else {
			log.warn("Feedback id is invalid for update");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public boolean deleteFeedback(int id) {
		if (fr.existsById(id)) {
			fr.deleteById(id);
			return true;
		} else {
			 log.warn("Feedback id is invalid for delete");
	         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Feedback> getFeedbacksByDeckId(int deckId) {
		if (fr.existsByDeckId(deckId)) {
			return fr.findByDeckIdOrderByCreatedOnDesc(deckId);
		} else {
			 log.warn("There are no cards for the given deck id");
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return(List<Feedback> )fr.findAll();
	}

}
