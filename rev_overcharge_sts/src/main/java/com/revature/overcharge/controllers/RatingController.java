package com.revature.overcharge.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;
import com.revature.overcharge.services.RatingService;

@CrossOrigin
@RestController
public class RatingController {

	private static final Logger log = Logger.getLogger(RatingController.class);

	@Autowired
	RatingService rs;

	//    @PostMapping(value = "/ratings", consumes = "application/json",
	//            produces = "application/json")
	//    public Rating addRating(@RequestBody Rating r) {
	//        log.info("Adding Rating");
	//        return rs.addRating(r);
	//    }

	@PostMapping(value = "/ratings", consumes = "application/json",
			produces = "application/json")
	public Rating saveRating(@RequestBody Rating r) {
		log.info("Saving Rating");
		return rs.saveRating(r);
	}

	@GetMapping(value = "/ratings")
	public List<Rating> getRatings(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer deckId) {
		return rs.getRatings(userId, deckId);
	}

	@DeleteMapping(value = "/ratings")
	public boolean deleteRating(@RequestBody RatingId rId) {
		return rs.deleteRating(rId);
	}

}