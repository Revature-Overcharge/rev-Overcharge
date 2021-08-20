package com.revature.overcharge.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.services.RatingService;
import com.revature.overcharge.beans.Rating;

@CrossOrigin
@RestController
public class RatingController {

	@Autowired
	RatingService rs;
	
	@PostMapping(value = "/ratings", consumes = "application/json", produces = "application/json")
	public Rating addRating(@RequestBody Rating r){
		return rs.addRating(r);
	}
	
	@GetMapping(value = "ratings/search")
	public Rating getRatingsByUserIdAndDeckId(@RequestParam(required = true) int userId, @RequestParam(required = true) int deckId){
		System.out.println("Getting RatingsByUserIdAndDeckId");
		return rs.getRatingByUserIdAndDeckId(userId, deckId);
	}
	
	@GetMapping(value = "ratings/search")
	public List<Rating> getRatingsByUserId(@RequestParam(required = true) int userId){
		System.out.println("Getting RatingsByUserId");
		return rs.getRatingsByUserId(userId);
	}
	
	@GetMapping(value = "ratings/search")
	public List<Rating> getRatingsByDeckId(@RequestParam(required = true) int deckId){
		System.out.println("Getting RatingsByDeckId");
		return rs.getRatingsByDeckId(deckId);
	}
	
	@PutMapping(value = "/ratings/update", consumes = "application/json", produces = "application/json")
	public Rating updateRating(@RequestBody Rating change){
		return rs.updateRating(change);
	}
	
	@DeleteMapping("/ratings/delete")
	public boolean deleteRating(@RequestParam(required = true) int userId, @RequestParam(required = true) int deckId) {
		System.out.println("Deleting Rating");
		return rs.deleteRatingByUserIdAndDeckId(userId, deckId);
	}
}
