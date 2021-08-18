package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.Rating;

public interface RatingRepo extends CrudRepository<Rating, Integer> {

    List<Rating> findByUserId(int userId);

    List<Rating> findBySetId(int setId);

    Rating findByUserIdAndSetId(int userId, int setId);

}
