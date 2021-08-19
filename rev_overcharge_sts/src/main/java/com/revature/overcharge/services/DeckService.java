package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Deck;

public interface DeckService {

    public Deck addDeck(Deck d);

    public Deck getDeck(int id);
    
    public List<Deck> getAllDecks();

    public Deck updateDeck(Deck newDeck);

    public boolean deleteDeck(int id);

    public List<Deck> getDecksByCreatorId(int creatorId);

}
