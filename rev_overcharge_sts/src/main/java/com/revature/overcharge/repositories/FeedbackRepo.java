package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Feedback;
@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Integer>{

	   public boolean existsByDeckId(int deckId);

	   public List<Feedback> findByDeckIdOrderByCreatedOnDesc(int deckId);
}
