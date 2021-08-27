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
	private int DAILY_MS = 86_400_000;

	@Override
	public User getAllObjectivesForUser(int id) {
		User u = us.getUser(id);
		getRateADeckDaily(u);
		getMarkFiveCardsDaily(u);
		getCreateADeckWeekly(u);
		get5StarDeckWeekly(u);
		getMarkTwoStudiedDeck(u);
		System.out.println(u);
		return u;
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
			int progressPercentage = cardsPastMidnight / countForGoal * 100;
			creator.getObjectives().add(new Objective(name, pointsToAward, progressPercentage, countForGoal));
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
			user.getObjectives().add(new Objective("Daily Login", 10, 100, 1));
		}
	}

	@Override
	public void setCreateADeckWeekly(int userId) {
		User u = us.getUser(userId);

		long createdTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, createdTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;

		List<Deck> decks = new ArrayList<Deck>();

		try {
			decks = ds.getDecksByCreatorId(u.getId());
		} catch (ResponseStatusException e) {
			u.getObjectives().add(new Objective("Create a Deck", 100, 0, 1));
			return;
		}
		int qualifiedDecks = 0;

		for (Deck deck : decks) {
			if (deck.getCreatedOn() >= startWeekTime && deck.getCreatedOn() <= endWeekTime) {
				qualifiedDecks++;
			}
		}

		if (qualifiedDecks == 1) {
			u.setPoints(u.getPoints() + 100);
			u.getObjectives().add(new Objective("Create a Deck", 100, 100, 1));
		} else {
			u.getObjectives().add(new Objective("Create a Deck", 100, (qualifiedDecks / 1 * 100), 1));
		}

		us.updateUser(u);
	}

	@Override
	public void getCreateADeckWeekly(User u) {

		long createdTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, createdTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;

		List<Deck> decks = new ArrayList<Deck>();

		try {
			decks = ds.getDecksByCreatorId(u.getId());
		} catch (ResponseStatusException e) {
			u.getObjectives().add(new Objective("Create a Deck", 100, 0, 1));
			return;
		}
		int qualifiedDecks = 0;

		for (Deck deck : decks) {
			if (deck.getCreatedOn() >= startWeekTime && deck.getCreatedOn() <= endWeekTime) {
				qualifiedDecks++;
			}
		}

		if (qualifiedDecks == 1) {
			u.getObjectives().add(new Objective("Create a Deck", 100, 100, 1));
		} else {
			u.getObjectives().add(new Objective("Create a Deck", 100, (qualifiedDecks / 1 * 100), 1));
		}
	}

	@Override
	public void set5StarDeckWeekly(Rating r) {
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

		// if get one 5 star rating
		if (match == 1) {
			u.setPoints(u.getPoints() + 300);
		}

		us.updateUser(u);
	}

	@Override
	public void get5StarDeckWeekly(User u) {
		u = us.getUser(u.getId());
		long currentTime = new Date().getTime();
		long startWeekTime = getWeekStart(WEEK_START_TIME, currentTime);
		long endWeekTime = startWeekTime + WEEKLY_MS;

		List<Deck> decks = new ArrayList<Deck>();

		try {
			decks = ds.getDecksByCreatorId(u.getId());
		} catch (ResponseStatusException e) {
			u.getObjectives().add(new Objective("Get 5 Star Rating", 300, 0, 1));
			return;
		}

		List<Rating> ratings = rs.getAllRatings();
		int matchedDeck = 0;

		for (Deck d : decks) {
			for (Rating r : ratings) {
				if (d.getId() == r.getDeckId()) {
					if ((r.getRatedOn() >= startWeekTime && r.getRatedOn() <= endWeekTime) && (r.getStars() == 5)) {
						matchedDeck++;
					}
				}
			}
		}
		if (matchedDeck == 1) {
//			u.setPoints(u.getPoints() + 300);
			u.getObjectives().add(new Objective("Get 5 Star Rating", 300, 100, 1));
		} else if (matchedDeck > 1) {
			u.getObjectives().add(new Objective("Get 5 Star Rating", 300, (matchedDeck / 1 * 100), 1));
		} else {
			u.getObjectives().add(new Objective("Get 5 Star Rating", 300, 0, 1));
		}
	}

	@Override
	public void setMarkTwoStudiedDeck(int userId) {
		User u = us.getUser(userId);
		List<Deck> allDecks = ds.getAllDecks();
		List<StudiedCard> userStudiedCards = scs.getStudiedCardsByUser(u.getId());

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
//			u.setPoints(u.getPoints() + 300);
			u.getObjectives().add(new Objective("Master 2 Sets", 300, 50, 2));
		} else if (deckCompleted < 2) {
			u.getObjectives().add(new Objective("Master 2 Sets", 300, (deckCompleted / 2 * 100), 2));
		} else {
			u.getObjectives().add(new Objective("Master 2 Sets", 300, 0, 2));
		}

		System.out.println(u.getObjectives());
		us.updateUser(u);

	}

	@Override
	public void getMarkTwoStudiedDeck(User u) {
		List<Deck> allDecks = ds.getAllDecks();
		List<StudiedCard> userStudiedCards = scs.getStudiedCardsByUser(u.getId());

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
			u.getObjectives().add(new Objective("Master 2 Sets", 300, 50, 2));
		} else if (deckCompleted < 2) {
			u.getObjectives().add(new Objective("Master 2 Sets", 300, (deckCompleted / 2 * 100), 2));
		} else {
			u.getObjectives().add(new Objective("Master 2 Sets", 300, 0, 2));
		}

	}

	@Override
	public void setMarkFiveCardsDaily(int userId) {
		User u = us.getUser(userId);
		List<StudiedCard> userStudiedCards = scs.getStudiedCardsByUser(u.getId());
		long midnight = getMidnight();

		int studiedCardCount = 0;

		for (StudiedCard scard : userStudiedCards) {
			if (scard.getStudiedOn() >= midnight && scard.getStudiedOn() <= midnight + DAILY_MS) {
				studiedCardCount++;
			}
		}

		if (studiedCardCount == 5) {
			u.setPoints(u.getPoints() + 50);
			u.getObjectives().add(new Objective("Master 5 cards", 50, 100, 5));
		} else {
			u.getObjectives().add(new Objective("Master 5 cards", 50, (studiedCardCount / 5 * 100), 5));
		}

		us.updateUser(u);

	}

	@Override
	public void getMarkFiveCardsDaily(User u) {
		List<StudiedCard> userStudiedCards = scs.getStudiedCardsByUser(u.getId());
		long midnight = getMidnight();

		double studiedCardCount = 0;

		for (StudiedCard scard : userStudiedCards) {
			if (scard.getStudiedOn() >= midnight && scard.getStudiedOn() <= midnight + DAILY_MS) {
				studiedCardCount++;
			}
		}

		u.getObjectives().add(new Objective("Master 5 cards", 50, (int) (studiedCardCount / 5 * 100), 5));
	}

	@Override
	public void setRateADeckDaily(int userId) {
		User u = us.getUser(userId);
		List<Rating> userRatings = rs.getRatingByUserId(u.getId());

		long midnight = getMidnight();

		int matchRating = 0;

		for (Rating r : userRatings) {
			if (r.getRatedOn() >= midnight && r.getRatedOn() <= midnight + DAILY_MS) {
				matchRating++;
			}
		}

		if (matchRating == 0) {
			u.getObjectives().add(new Objective("Rate a Deck", 20, 0, 1));
		} else if (matchRating == 1) {
			u.setPoints(u.getPoints() + 20);
			u.getObjectives().add(new Objective("Rate a Deck", 20, 100, 1));
		} else {
			u.getObjectives().add(new Objective("Rate a Deck", 20, (matchRating / 1 * 100), 1));
		}

		us.updateUser(u);

	}

	@Override
	public void getRateADeckDaily(User u) {
		List<Rating> userRatings = rs.getRatingByUserId(u.getId());

		long midnight = getMidnight();

		int matchRating = 0;

		for (Rating r : userRatings) {
			if (r.getRatedOn() >= midnight && r.getRatedOn() <= midnight + DAILY_MS) {
				matchRating++;
			}
		}

		if (matchRating == 0) {
			u.getObjectives().add(new Objective("Rate a Deck", 20, 0, 1));
		} else if (matchRating == 1) {
			u.getObjectives().add(new Objective("Rate a Deck", 20, 100, 1));
		} else {
			u.getObjectives().add(new Objective("Rate a Deck", 20, (matchRating / 1 * 100), 1));
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
