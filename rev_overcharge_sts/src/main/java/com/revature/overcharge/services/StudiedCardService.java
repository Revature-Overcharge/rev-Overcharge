package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.CompositeRequest;
import com.revature.overcharge.beans.StudiedCard;

public interface StudiedCardService {

    public StudiedCard addStudiedCard(CompositeRequest compReq);

    public List<StudiedCard> getStudiedCards(Integer userId, Integer cardId);

    public StudiedCard updateStudiedCard(StudiedCard newSc);

    public boolean deleteStudiedCard(int userId, int cardId);

}
