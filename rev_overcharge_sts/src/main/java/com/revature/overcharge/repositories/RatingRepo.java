package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

@Repository
public interface RatingRepo extends CrudRepository<Rating, RatingId> {

    List<Rating> findByUserId(int userId);

    List<Rating> findByDeckId(int deckId);

    Rating findByUserIdAndDeckId(int userId, int deckId);

    boolean deleteByUserIdAndDeckId(int userId, int deckId);

}
