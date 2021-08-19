package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Card;

@Repository
public interface CardRepo extends CrudRepository<Card, Integer>{

	List<Card> findBySetId(int setId);
	
}
