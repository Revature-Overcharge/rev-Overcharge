package com.revature.overcharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Feedback;
import com.revature.overcharge.services.FeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService fs;
	
	@PostMapping(value = "/decks/{id}/feedbacks", consumes = "application/json", produces = "application/json")
	public Feedback addFeedback(@PathVariable("id") int deckId, @RequestBody Feedback f) {
		return fs.addFeedback(deckId, f);
	}
	
	@GetMapping(value = "/feedbacks/{id}")
    public Feedback getFeedback(@PathVariable("id") int id) {
        return fs.getFeedback(id);
    }

    @GetMapping(value = "/feedbacks")
    public List<Feedback> getAllFeedbacks() {
        return fs.getAllFeedbacks();
    }

    @GetMapping(value = "/decks/{id}/feedbacks")
    public List<Feedback> getFeedbacksByDeckId(@PathVariable("id") int id) {
        return fs.getFeedbacksByDeckId(id);
    }
    
    @PutMapping(value = "/feedbacks", consumes = "application/json",
            produces = "application/json")
    public Feedback updateFeedback(@RequestBody Feedback f) {
        return fs.updateFeedback(f);
    }
    
    @DeleteMapping(value = "/feedbacks/{id}")
    public boolean deleteFeedback(@PathVariable("id") int id) {
    	return fs.deleteFeedback(id);
    }

}
