package com.revature.overcharge.services;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;

import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.Feedback;
import com.revature.overcharge.repositories.FeedbackRepo;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTests {
	
	@Mock
	private FeedbackRepo fr;
	
	@Mock
	private DeckServiceImpl ds;
	
	@InjectMocks
	private FeedbackServiceImpl fs;
	
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void setUp() throws Exception {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		 closeable.close();
	}
		
	
	@Test
	void addFeedbackTest() {
		Deck deck = new Deck();
		deck.setId(1);
		Feedback feedback = new Feedback(null, "my Feedback");
		
		Mockito.when(fr.save(feedback)).thenReturn(new Feedback(1, deck, null, "my Feedback"));
		Mockito.when(ds.getDeck(1)).thenReturn(deck);
		Feedback actualFeedback = fs.addFeedback(1, feedback);
		
		Feedback expectFeedback = new Feedback(1, deck, null, "my Feedback");
		
		Assertions.assertEquals(actualFeedback, expectFeedback);
		
	}
	
	@Test
	void addFeedbackFailure() {
		Feedback feedback = new Feedback(null, "my Feedback");
		Mockito.when(fr.existsById(feedback.getId())).thenReturn(true);
		  assertThrows(ResponseStatusException.class, () -> {
			  fs.addFeedback(1, feedback);
		  });
		  
	}
	
	@Test
	void getFeedbackTest() {
		Deck deck = new Deck();
		Feedback feedback = new Feedback(1, deck, null, "my Feedback");
		Mockito.when(fr.existsById(feedback.getId())).thenReturn(true);
		Mockito.when(fr.findById(feedback.getId())).thenReturn(Optional.of(feedback));
		
		Feedback actualFeedback = fs.getFeedback(1);
		Feedback expectedFeedback = feedback;
		Assertions.assertEquals(actualFeedback, expectedFeedback);	
		
	}
	

	@Test
	void getFeedbackFailure() {

		Mockito.when(fr.existsById(1)).thenReturn(false);
		
        assertThrows(ResponseStatusException.class, () -> {
            fs.getFeedback(1);
        });
	}
	
	@Test
	void updateFeedbackTest() {
		Feedback newFeedback = new Feedback(1, null, null, "my Feedback");
		Mockito.when(fr.existsById(newFeedback.getId())).thenReturn(true);
		Mockito.when(fr.save(newFeedback)).thenReturn(newFeedback);
		Feedback actualFeedback = fs.updateFeedback(newFeedback);
		
		Feedback expectedFeedback = new Feedback(1, null, null, "my Feedback");
		
		Assertions.assertEquals(actualFeedback, expectedFeedback);	
		
		}
	

	@Test
	void updateFeedbackFailure() {
		Feedback newFeedback = new Feedback(1, null, null, "my Feedback");
		Mockito.when(fr.existsById(newFeedback.getId())).thenReturn(false);
		 assertThrows(ResponseStatusException.class, () -> {
	            fs.updateFeedback(newFeedback);
	        });
	}
	

	@Test
	void deleteFeedbackTest() {
		Deck deck = new Deck();
		Feedback feedback = new Feedback(1, deck, null, "my Feedback");
		Mockito.when(fr.existsById(feedback.getId())).thenReturn(true);
		Assertions.assertEquals(fs.deleteFeedback(1), true);	
	}
	
	@Test
	void deleteFeedbackFailure() {
		Deck deck = new Deck();
		Feedback feedback = new Feedback(1, deck, null, "my Feedback");
		Mockito.when(fr.existsById(feedback.getId())).thenReturn(false);
		 assertThrows(ResponseStatusException.class, () -> {
	            fs.deleteFeedback(1);
	        });
	}
	
	@Test
	void getFeedbacksByDeckTest() {
		Deck deck = new Deck();
		deck.setId(1);
		Feedback feedback1 = new Feedback(1, deck, null, "my Feedback");
		Feedback feedback2 = new Feedback(2, deck, null, "second Feedback");
		List<Feedback> fList = new ArrayList<Feedback>();
		fList.add(feedback1);
		fList.add(feedback2);
		Mockito.when(fr.existsByDeckId(1)).thenReturn(true);
		Mockito.when(fr.findByDeckIdOrderByCreatedOnDesc(1)).thenReturn(fList);
		List<Feedback> actualList = fs.getFeedbacksByDeckId(1);
		Assertions.assertEquals(fList, actualList);
	}
	
	@Test
	void getFeedbacksByDeckTestFaliure() {
		Mockito.when(fr.existsByDeckId(1)).thenReturn(false);
		 assertThrows(ResponseStatusException.class, () -> {
	            fs.getFeedbacksByDeckId(1);
	        });
	}
	
	
	@Test
	void getAllFeedbacksTest() {
		Deck deck = new Deck();
		Feedback feedback1 = new Feedback(1, deck, null, "my Feedback");
		Feedback feedback2 = new Feedback(2, deck, null, "second Feedback");
		List<Feedback> fList = new ArrayList<Feedback>();
		fList.add(feedback1);
		fList.add(feedback2);
		Mockito.when(fr.findAll()).thenReturn(fList);
		List<Feedback> actualList = fs.getAllFeedbacks();
		Assertions.assertNotNull(actualList);
	}


}
