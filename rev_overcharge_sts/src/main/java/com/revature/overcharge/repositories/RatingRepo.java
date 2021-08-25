package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

@Repository
public interface RatingRepo extends CrudRepository<Rating, RatingId> {

    public boolean existsByUserIdAndDeckId(int userId, int deckId);

    public List<Rating> getByUserIdAndDeckId(int userId, int deckId);

    public List<Rating> getByUserId(int userId);

    public List<Rating> getByDeckId(int deckId);
    
    public List<Rating> findByDeckId(int deckId);

    /*
     * List<Rating> findByUserId(int userId);
     * 
     * List<Rating> findByDeckId(int deckId);
     * 
     * public Rating findByUserIdAndDeckId(int userId, int deckId);
     * 
     * boolean deleteByUserIdAndDeckId(int userId, int deckId);
     */

}
