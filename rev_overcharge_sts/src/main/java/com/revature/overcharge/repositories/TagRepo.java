package com.revature.overcharge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.TechTag;

public interface TagRepo extends CrudRepository<TechTag, Integer>{

	TechTag getById(int id);

}
