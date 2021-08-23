package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

public interface RatingService {
	
	public Rating addRating(Rating r);
	
	public List<Rating> getRatings(Integer userId, Integer deckId);
	
	public boolean deleteRating(RatingId rId);

	/*
	 * public Rating addRating(Rating r);
	 * 
	 * public Rating getRatingByUserIdAndDeckId(int userId, int deckId);
	 * 
	 * public Rating updateRating(Rating newRating);
	 * 
	 * public boolean deleteRatingByUserIdAndDeckId(int userId, int deckId);
	 * 
	 * public List<Rating> getRatingsByUserId(int userId);
	 * 
	 * public List<Rating> getRatingsByDeckId(int deckId);
	 */

}
