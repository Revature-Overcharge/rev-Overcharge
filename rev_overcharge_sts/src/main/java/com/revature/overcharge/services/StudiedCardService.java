package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;

public interface StudiedCardService {

    public StudiedCard addStudiedCard(StudiedCard sc);

    public List<StudiedCard> getStudiedCards(Integer userId, Integer cardId);

    public boolean deleteStudiedCard(StudiedCardId scId);
    
    public List<StudiedCard> getStudiedCardsByUser(Integer userId);

	public StudiedCard updateCard(StudiedCard sc);

}
