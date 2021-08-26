package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.User;

public interface ObjectiveService {

    public List<Objective> getAllObjectivesForUser(int id);

    public void addCardObj(Card c);

    public void addDeckObj(Deck d);

    public void loginObj(User user);
    
    public void setCreateADeckWeekly(int userId);
    
	public void setMarkTwoStudiedDeck(int userId);
	
	public void get5StarDeckWeekly(User user);
	
	public void set5StarDeckWeeklyFromRating(Rating r);
	
	public void setMarkFiveCardsDaily(int userId);
	
	public void setRateADeckDaily(int userId);
		

}
