package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;

public interface ObjectiveService {

    public List<Objective> getAllObjectivesForUser(String id);

    public void addCardObj(Card c);

    public void addDeckObj(Deck d);

    public void loginObj();

}
