package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.TechTag;
import com.revature.overcharge.beans.User;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class ObjectiveServiceTests {

	@Autowired
    private ObjectiveService os;
	
	@Autowired
	private DeckService ds;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private CardService cs;
	
	@Autowired
	private RatingService rs;
	
	@Autowired
	private StudiedCardService scs;
	
    
	@Test
	@Transactional
    void loginObjTest() {
		long currentTime = new Date().getTime();
		User u = new User("username", "password2", 0, 0, currentTime - 86410000);
		u = us.addUser(u);
//		Mockito.when(rs.addUser(u)).thenReturn(new User(1, u.getUsername(), u.getPassword(), u.getPoints(), u.getLastLogin()));
		os.loginObj(u);
		assertEquals(10, u.getPoints());
    }
	
	@Test
	@Transactional
	void setAdd4CardsDailyTest() {
		long currentTime = new Date().getTime();
	
		User u = new User("username2", "password3", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);
		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "Deck 2", currentTime, cards, null, null);
		d = ds.addDeck(d);
		
		Card c3 = new Card("question3", "answer3", currentTime);
		c3 = cs.addCard(d.getId(), c3);
		
		os.setAdd4CardsDaily(d.getId(), c3);
		
		assertEquals(0, u.getObjectives().size());
		
	}
	
	@Test
	@Transactional
	void setAdd4CardsDailyCompleteTest() {
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User("username2", "password3", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);
		Card c3 = new Card("question3", "answer3", currentTime);
		Card c4 = new Card("question4", "answer4", currentTime);
		
		
//		TechTag t1 = new TechTag("Maven");
//		
//		Set<TechTag> st = new HashSet<>();
//		
//		st.add(t1);


		List<Card> cards = Arrays.asList(c1, c2, c3, c4);
		
		Deck d = new Deck(u, "Deck 2", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		int deckPoints = 100;
		int add4CardsPoints = 50;

		assertEquals((deckPoints + add4CardsPoints), us.getUser(u.getId()).getPoints());
		
	}
	
	@Test
	@Transactional
	void getAdd4CardsDailyCompleteTest() {
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User("username3", "password4", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);
		Card c3 = new Card("question3", "answer3", currentTime);
		Card c4 = new Card("question4", "answer4", currentTime);

		List<Card> cards = Arrays.asList(c1, c2, c3, c4);
		
		Deck d = new Deck(u, "Deck 2", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		os.getAdd4CardsDaily(u);
		
		List<Objective> objectives = u.getObjectives();	
		
		assertEquals("Create 4 Cards", objectives.get(0).getName());
				
	}
	
	@Test
	@Transactional
	void setCreateADeckWeeklyTest() {
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User("username4", "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);

		List<Card> cards = Arrays.asList(c1);
		
		Deck d = new Deck(u, "Deck 2", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		int deckPoints = 100;
		System.out.println(u);
		assertEquals(deckPoints, us.getUser(u.getId()).getPoints());

	}
	
	@Test
	@Transactional
	void getCreateADeckWeeklyTest() {
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User("username5", "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);

		List<Card> cards = Arrays.asList(c1);
		
		Deck d = new Deck(u, "Deck 2", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		os.getCreateADeckWeekly(u);
		List<Objective> objectives = u.getObjectives();	
		assertEquals("Create a Deck", objectives.get(0).getName());

	}
	
	@Test
	@Transactional
	void set5StarDeckWeeklyTest() {
		
		User u = createNewUserAndDeck("user6");
		
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u2 = new User("user7", "password5", 0, 0, currentTime);
		u2 = us.addUser(u2);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u2, "New Deck for " + "user7", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		Rating r = new Rating(u.getId(), d.getId(), 5, currentTime);
		rs.saveRating(r);
		
		int createDeckPoints = 100;
		int get5Starpoints = 300;
		assertEquals(createDeckPoints + get5Starpoints, u2.getPoints());	
	}
	
	@Test
	@Transactional
	void get5StarDeckWeeklyTest() {
		
		User u = createNewUserAndDeck("user7");
		
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u2 = new User("user8", "password5", 0, 0, currentTime);
		u2 = us.addUser(u2);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u2, "New Deck for " + "user8", currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		Rating r = new Rating(u.getId(), d.getId(), 5, currentTime);
		rs.saveRating(r);
		
		os.get5StarDeckWeekly(u);
		List<Objective> objectives = u.getObjectives();	
		assertEquals("Get a 5 Star Rating", objectives.get(0).getName());

	}
	
	@Test 
	@Transactional
	void setMarkAllCardsInDeckStudiedWeeklyTest() {
		String username = "user9";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		for (Card c : d.getCards()) {
			StudiedCard sc = new StudiedCard(u.getId(), c.getId(), currentTime);
			scs.addStudiedCard(sc);
			
		}
		
		int createDeckPoints = 100;
		int markAllCardsPoints = 300;
		
		assertEquals(createDeckPoints + markAllCardsPoints, u.getPoints());
		
	}
	
	@Test
	@Transactional
	void getMarkAllCardsInDeckStudiedWeeklyTest() {
		String username = "user9";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		for (Card c : d.getCards()) {
			StudiedCard sc = new StudiedCard(u.getId(), c.getId(), currentTime);
			scs.addStudiedCard(sc);
			
		}
		
		os.getMarkAllCardsInDeckStudiedWeekly(u);
		List<Objective> objectives = u.getObjectives();	
		assertEquals("Master a Deck", objectives.get(0).getName());
		
	}
	
	@Test
	@Transactional
	void setMarkFiveCardsDailyTest() {
		String username = "user10";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);
		Card c3 = new Card("question3", "answer3", currentTime);
		Card c4 = new Card("question4", "answer4", currentTime);
		Card c5 = new Card("question5", "answer5", currentTime);
		Card c6 = new Card("question6", "answer6", currentTime);

		List<Card> cards = Arrays.asList(c1, c2, c3, c4, c5, c6);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		for (int i=0; i<5; i++) {
			Card c = d.getCards().get(i);
			StudiedCard sc = new StudiedCard(u.getId(), c.getId(), currentTime);
			scs.addStudiedCard(sc);
			
		}
		
		int createDeckPoints = 100;
		int mark5CardsPoints = 100;
				
		assertEquals(1700, u.getPoints());
		
	}
	
	@Test
	@Transactional
	void getMarkFiveCardsDailyTest() {
		String username = "user11";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);
		Card c3 = new Card("question3", "answer3", currentTime);
		Card c4 = new Card("question4", "answer4", currentTime);
		Card c5 = new Card("question5", "answer5", currentTime);
		Card c6 = new Card("question6", "answer6", currentTime);

		List<Card> cards = Arrays.asList(c1, c2, c3, c4, c5, c6);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		for (int i=0; i<5; i++) {
			Card c = d.getCards().get(i);
			StudiedCard sc = new StudiedCard(u.getId(), c.getId(), currentTime);
			scs.addStudiedCard(sc);
			
		}
		
		os.getMarkFiveCardsDaily(u);
		List<Objective> objectives = u.getObjectives();	
		assertEquals("Master 5 Cards", objectives.get(0).getName());
		
	}
	
	@Test
	@Transactional
	void setRateADeckDailyTest() {
		User ratingUser = createNewUser("user13");

		String username = "user12";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		Rating r = new Rating(ratingUser.getId(), d.getId(), 5, currentTime);
		rs.saveRating(r);
		
		int ratingPoints = 20;
		assertEquals(ratingPoints, ratingUser.getPoints());
		
	}
	
	@Test
	@Transactional
	void getRateADeckDailyTest() {
		User ratingUser = createNewUser("user13");

		String username = "user12";
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		
		Rating r = new Rating(ratingUser.getId(), d.getId(), 5, currentTime);
		rs.saveRating(r);
		
		os.getRateADeckDaily(ratingUser);
		List<Objective> objectives = ratingUser.getObjectives();	
		assertEquals("Rate a Deck", objectives.get(0).getName());
		
	}
	
	@Test
	@Transactional
	void getAllObjectivesForUserTest() {
		User user = createNewUser("user14");
		os.getAllObjectivesForUser(user.getId());
		assertEquals(0, user.getPoints());;
	}
	
	private User createNewUser(String username) {
		return us.addUser(new User(username, "password"+username, 0, 0, new Date().getTime()));
	}
	
	
	private User createNewUserAndDeck(String username) {
		long currentTime = new Date().getTime();
		currentTime -= 30000;
		
		User u = new User(username, "password5", 0, 0, currentTime);
		u = us.addUser(u);
		Card c1 = new Card("question1", "answer1", currentTime);
		Card c2 = new Card("question2", "answer2", currentTime);

		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "New Deck for " + username, currentTime, cards, null, null);
		d = ds.addDeckAndCards(d);
		return u;
	}
	
	

}
