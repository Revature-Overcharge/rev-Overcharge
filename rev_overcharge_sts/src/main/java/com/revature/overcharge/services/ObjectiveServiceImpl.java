package com.revature.overcharge.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.User;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

    @Override
    public List<Objective> getAllObjectivesForUser(String id) {
        return null;
    }

    @Override
    public void addCardObj(Card c) {
        
    }

    @Override
    public void addDeckObj(Deck d) {
        
    }

    @Override
    public void loginObj(User user) {
    	long midnight = getMidnight();
        if (midnight >= user.getLastLogin()) {
        	user.setPoints(user.getPoints() + 10);
        } 
    }
    
    private long getMidnight() {
    	Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime(); 
        return d1.getTime();
    }

}
