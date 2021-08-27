package com.revature.overcharge.services;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.User;

public interface ObjectiveService {

    public User getAllObjectivesForUser(int id);

    public void setAdd4CardsDaily(int deckId, Card c);
    public void getAdd4CardsDaily(User u);

    public void loginObj(User user);
    
    public void setCreateADeckWeekly(int userId);
    public void getCreateADeckWeekly(User u);
    
	public void setMarkAllCardsInDeckStudiedWeekly(int userId);
	public void getMarkAllCardsInDeckStudiedWeekly(User u);
	
	public void set5StarDeckWeekly(Rating r);
	public void get5StarDeckWeekly(User user);
	
	public void setMarkFiveCardsDaily(int userId);
	public void getMarkFiveCardsDaily(User u);

	
	public void setRateADeckDaily(int userId);
	public void getRateADeckDaily(User u);


}
