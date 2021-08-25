package com.revature.overcharge.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.User;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

	@Autowired
	private DeckService ds;

	@Autowired
	private UserService us;

	@Autowired
	RatingService rs;

	@Autowired
	StudiedCardService scs;

	private long WEEK_START_TIME = 1_627_898_400_000L;
	private int WEEKLY_MS = 604_800_000;

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
			creator.getObjectives().add(new Objective(name, pointsToAward, cardsPastMidnight, countForGoal));
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
			get5StarDeckWeekly(user);
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
		long endWeekTime = startWeekTime + WEEKLY_MS;

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

	@Override
	public void get5StarDeckWeekly(User u) {
		long currentTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, currentTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;

		List<Deck> decks = new ArrayList<Deck>();

		try {
			decks = ds.getDecksByCreatorId(u.getId());
		} catch (ResponseStatusException e) {
			return;
		}

		List<Rating> ratings = rs.getAllRatings();

		deckLoop: for (Deck d : decks) {
			for (Rating r : ratings) {
				if (d.getId() == r.getDeckId()) {
					if ((r.getRatedOn() >= startWeekTime && r.getRatedOn() <= endWeekTime) && (r.getStars() == 5)) {
//						u.setPoints(u.getPoints() + 300);
						u.getObjectives().add(new Objective("Get a Five Star Rating on a Deck", 300, 1, 1));
						break deckLoop;
					}
				}
			}
		}
//		us.updateUser(u);
	}

	@Override
	public void set5StarDeckWeeklyFromRating(Rating r) {
		Deck d = ds.getDeck(r.getDeckId());
		User u = us.getUser(d.getCreator().getId());

		long currentTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, currentTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;
		int match = 0;

		List<Rating> ratings = rs.getRatingsByDeckId(d.getId());

		for (Rating rating : ratings) {
			if ((rating.getRatedOn() >= startWeekTime && rating.getRatedOn() <= endWeekTime)
					&& (rating.getStars() == 5)) {
				match++;
			}
		}

		if (match == 1) {
			u.setPoints(u.getPoints() + 300);
		}

		us.updateUser(u);
	}

	// Not tested yet, but 70% sure works.
	@Override
	public void markTwoStudiedDeck(StudiedCard sc) {
		User u = us.getUser(sc.getUserId());
		List<Deck> allDecks = ds.getAllDecks();
		List<StudiedCard> userStudiedCards = scs.getStudiedCardsByUser(u.getId());

		System.out.println(userStudiedCards);

		long currentTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, currentTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;

		int deckCompleted = 0;

		for (Deck d : allDecks) {
			int cardMatch = 0;
			for (Card c : d.getCards()) {
				studiedCardLoop: for (StudiedCard scard : userStudiedCards) {
					if ((scard.getCardId() == c.getId())
							&& (scard.getStudiedOn() >= startWeekTime && scard.getStudiedOn() <= endWeekTime)) {
						cardMatch++;
						break studiedCardLoop;
					}
				}
			}
			if (cardMatch == d.getCards().size()) {
				deckCompleted++;
			}
		}

		if (deckCompleted == 1) {
			u.setPoints(u.getPoints() + 300);
			u.getObjectives().add(new Objective("Mark All Cards in Two Sets as Studied", 300, 1, 2));
			sc.setStudiedOn(sc.getStudiedOn() + WEEKLY_MS);
			scs.updateCard(sc);
		} else if (deckCompleted < 2) {
			u.getObjectives().add(new Objective("Mark All Cards in Two Sets as Studied", 300, deckCompleted, 2));
		}
		
		System.out.println(u.getObjectives());
		us.updateUser(u);

	}

	private long getWeekStart(long startTime, long currentTime) {
		while (startTime <= currentTime) {
			startTime += WEEKLY_MS;
			if (startTime > currentTime) {
				return startTime -= WEEKLY_MS;
			}
		}
		return startTime;
	}

}
