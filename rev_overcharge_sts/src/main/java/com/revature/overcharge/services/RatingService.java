package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Rating;

public interface RatingService {

    public Rating addRating(Rating r);

    public Rating getRatingByUserIdAndDeckId(int userId, int deckId);

    public Rating updateRating(Rating newRating);

    public boolean deleteRatingByUserIdAndDeckId(int userId, int deckId);

    public List<Rating> getRatingsByUserId(int userId);

    public List<Rating> getRatingsByDeckId(int deckId);

}
