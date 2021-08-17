package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.FinishedCard;

public interface FinishedCardRepo
        extends CrudRepository<FinishedCard, Integer> {

    List<FinishedCard> findByUserId(int userId);

    List<FinishedCard> findByCardId(int cardId);

}
