package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Deck;

@Repository
public interface DeckRepo extends CrudRepository<Deck, Integer> {

    List<Deck> findByCreatorId(int creatorId);

}
