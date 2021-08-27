package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.User;


@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class ObjectiveServiceTests {
	
	@Autowired
    public ObjectiveService os;
	
	@MockBean
	UserService rs;
	
	@MockBean
	DeckService ds;
    
	@Test
    void loginObjTest() {
        
		User u = new User("username", "password2", 0, 1630058559L);
		Mockito.when(rs.addUser(u)).thenReturn(new User(1, u.getUsername(), u.getPassword(), u.getPoints(), u.getLastLogin()));
		os.loginObj(u);
		assertEquals(10, u.getPoints());
    }
	
	@Test 
	void setCreateADeckWeeklyTest() {

		User u = new User("username2", "password3", 0, 1630058559L);
		Card c1 = new Card("question1", "answer1", 1630058559L);
		Card c2 = new Card("question2", "answer2", 1630058559L);
		
		List<Card> cards = Arrays.asList(c1, c2);
		
		Deck d = new Deck(u, "Deck 2", 1630058559L, cards);
		
		Mockito.when(rs.addUser(u)).thenReturn(new User(1, u.getUsername(), u.getPassword(), u.getPoints(), u.getLastLogin()));
		Mockito.when(rs.getUser(u.getId())).thenReturn(new User(1, u.getUsername(), u.getPassword(), u.getPoints(), u.getLastLogin()));
		Mockito.when(ds.addDeckAndCards(d)).thenReturn(new Deck(1, ));
//		Mockito.doThrow(ResponseStatusException.class).when(ds).getDecksByCreatorId(u.getId());

		os.setCreateADeckWeekly(u.getId());
		System.out.println(u.getObjectives());
				
	}

}
