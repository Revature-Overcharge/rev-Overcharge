package com.revature.overcharge.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.User;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

    @Autowired
    private DeckService ds;
    
    @Autowired
    private UserService us;
    
    long WEEK_START_TIME = 1627887600000L;
    int WEEKLY_SEC = 604800000;

    @Override
    public List<Objective> getAllObjectivesForUser(String id) {
        return null;
    }

    @Override
    public void addCardObj(Card c) {
        String name = "Daily Create 3 Cards";
        int pointsToAward = 50;
        int cardsPastMidnight = 0;
        int countForGoal = 3;

        long midnight = getMidnight();

        User creator = c.getDeck().getCreator();
        List<Deck> decks = ds.getDecksByCreatorId(creator.getId());

        for (Deck deck : decks) {
            List<Card> cards = deck.getCards();
            for (Card card : cards) {
                if (card.getCreatedOn() > midnight) {
                    cardsPastMidnight++;
                }
            }
        }
        if (cardsPastMidnight == countForGoal) {
            creator.setPoints(creator.getPoints() + pointsToAward);
            creator.getObjectives().add(new Objective(name, pointsToAward,
                    cardsPastMidnight, countForGoal));
        }
    }

    @Override
    public void addDeckObj(Deck d) {
//        int creatorId = d.getCreator().getId();
//        User creator = us.getById()
//        List<Deck> decks = u.getCreatedDecks();
    }

    @Override
    public void loginObj(User user) {
        long midnight = getMidnight();
        if (midnight >= user.getLastLogin()) {
            user.setPoints(user.getPoints() + 10);
            user.getObjectives().add(new Objective("Daily Login", 10, 1, 1));
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

	@Override
	public void createADeckWeekly(Deck d) {
		User u = us.getUser(d.getCreator().getId());
		d.setCreator(u);
		
		long createdTime = d.getCreatedOn();
		long startWeekTime = getWeekStart(WEEK_START_TIME, createdTime);
		long endWeekTime = startWeekTime + WEEKLY_SEC;
		
		List<Deck> decks = ds.getDecksByCreatorId(u.getId());
		
		int qualifiedDecks = 0;

		for (Deck deck : decks) {
			if (deck.getCreatedOn() >= startWeekTime && deck.getCreatedOn() <= endWeekTime) {
				qualifiedDecks++;
			}
		}
		
		if (qualifiedDecks == 1) {
			u.setPoints(u.getPoints() + 100);
			u.getObjectives().add(new Objective("Create a Set", 100, 1, 1));
		}

		us.updateUser(u);
	}
	
	private long getWeekStart(long startTime, long currentTime) {
		while (startTime <= currentTime) {
			startTime += WEEKLY_SEC;
			if (startTime > currentTime) {
				return startTime -= WEEKLY_SEC;
			}
		}
		return startTime;
	}

}
