package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.Set;

@Repository
public interface SetRepo extends CrudRepository<Set, Integer> {

    List<Set> findByCreatorId(int creatorId);

}
