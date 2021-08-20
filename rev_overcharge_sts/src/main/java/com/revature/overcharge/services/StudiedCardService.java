package com.revature.overcharge.services;

import com.revature.overcharge.beans.StudiedCard;

public interface StudiedCardService {
    
    public StudiedCard addStudiedCard(StudiedCard sc);
    
    public StudiedCard getStudiedCardByUserIdAndCardId(int userId, int cardId);
    
    public StudiedCard updateStudiedCard(StudiedCard newSc);
    
}
