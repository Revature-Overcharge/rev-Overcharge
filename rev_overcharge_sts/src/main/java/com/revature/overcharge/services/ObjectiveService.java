package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.User;

public interface ObjectiveService {

    public List<Objective> getAllObjectivesForUser(String id);

    public void addCardObj(Card c);

    public void addDeckObj(Deck d);

    public void loginObj(User user);
    
    public void createADeckWeekly(User u);
    
    // Show if user completed the 5star object on login
    public void get5StarDeckWeekly(User u);

    // Determine if deck has 5 star via rating route
	public void set5StarDeckWeeklyFromRating(Rating r);
		
	public void markTwoStudiedDeck(User u);
	
	public List<StudiedCard> markFiveCardsDaily(User u);
	
	public void rateADeckDaily(User u);
	
	public User getAllObjectives(User u);
	

}
