package com.revature.overcharge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;

public interface StudiedCardRepo
        extends CrudRepository<StudiedCard, StudiedCardId> {

    public boolean existsByUserIdAndCardId(int userId, int cardId);

    public List<StudiedCard> getByUserIdAndCardId(int userId, int cardId);

    public List<StudiedCard> getByUserId(int userId);

    public List<StudiedCard> getByCardId(int cardId);

}
