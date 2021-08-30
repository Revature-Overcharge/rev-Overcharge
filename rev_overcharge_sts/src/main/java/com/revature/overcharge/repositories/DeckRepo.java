package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Deck;

@Repository
public interface DeckRepo extends CrudRepository<Deck, Integer> {

    public boolean existsByCreatorId(int creatorId);
    
    public List<Deck> getByCreatorId(int creatorId);

}