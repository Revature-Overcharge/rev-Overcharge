package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Card;

public interface CardService {

	public Card addFlashcard(Card f);
	
	public Card getFlashcard(int id);
	
	public Card updateFlashcard(Card newCard);
	
	public boolean deleteFlashcard(int id);
	
	public List<Card> getFlashcardBySetId(int setId);
	
}
