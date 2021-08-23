package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Card;

@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {

    public boolean existsByDeckId(int deckId);
    
    public List<Card> findByDeckId(int deckId);

}
