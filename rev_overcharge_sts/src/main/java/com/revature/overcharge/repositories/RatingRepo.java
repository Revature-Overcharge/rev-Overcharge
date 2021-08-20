package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.User;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Integer> {

    List<Rating> findByUser(User user);

    List<Rating> findByDeck(Deck deck);

    Rating findByUserAndDeck(User user, Deck deck);

    boolean deleteByUserIdAndDeckId(int userId, int deckId);

}
