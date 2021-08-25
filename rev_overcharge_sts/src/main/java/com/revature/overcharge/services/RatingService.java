package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

public interface RatingService {

//    public Rating addRating(Rating r);

    public Rating saveRating(Rating r);

    public List<Rating> getRatings(Integer userId, Integer deckId);

    public boolean deleteRating(RatingId rId);
    
    public List<Rating> getAllRatings();
    
    public List<Rating> getRatingsByDeckId(int deckId);
    
    public Rating updateRating(Rating r);

}
