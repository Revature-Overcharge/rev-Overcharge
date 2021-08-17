package com.revature.overcharge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.repositories.CardRepo;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepo cr;
	
	@Override
	public Card addCard(Card c) {
		return cr.save(c);
	}

	@Override
	public Card getCard(int id) {
		try {
			return cr.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Card updateCard(Card newCard) {
		return cr.save(newCard);
	}

	@Override
	public boolean deleteCard(int id) {
		try { 
			cr.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public List<Card> getCardsBySetId(int setId) {
		return cr.findBySetId(setId);
	}

}
