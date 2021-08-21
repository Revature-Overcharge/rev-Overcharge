package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.StudiedCard;

public interface StudiedCardRepo extends CrudRepository<StudiedCard, Integer> {

    List<StudiedCard> findByUserId(int userId);

    List<StudiedCard> findByCardId(int cardId);

    List<StudiedCard> findByUserIdAndCardId(int userId, int cardId);
    
    boolean existsByUserIdAndCardId(int userId, int cardId);

    boolean deleteByUserIdAndCardId(int userId, int cardId);

}
