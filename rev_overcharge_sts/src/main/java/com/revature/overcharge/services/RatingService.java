package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

public interface RatingService {

    public Rating saveRating(Rating r);

    public List<Rating> getRatings(Integer userId, Integer deckId);

    public Rating updateRating(Rating r);

    public boolean deleteRating(RatingId rId);

    public Double calculateAvgRating(int deckId);

}
