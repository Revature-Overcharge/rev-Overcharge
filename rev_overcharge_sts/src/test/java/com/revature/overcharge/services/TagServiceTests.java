package com.revature.overcharge.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.TechTag;
import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.CardRepo;
import com.revature.overcharge.repositories.DeckRepo;
import com.revature.overcharge.repositories.TagRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class TagServiceTests {

	
	@Autowired
	public TagServiceImpl ts;
	
	@MockBean
	TagRepo tr;

	

	@Before
	public void setUp() throws Exception {
		this.tr = mock(TagRepo.class); //using mockito to creat fake ship doa object
		
		this.ts = new TagServiceImpl(tr); //injecting mocked object into shipservice object
	}
	
	
	
	@Test
	public void test_getAllTags_positive() throws SQLException {
		//becuase shipdoa object is mocked, we need to specify what we want the mocked clientdao to return
		//whenever we invoke the clientdoa 
		List<TechTag> mockReturnValues = new ArrayList<>();
		mockReturnValues.add(new TechTag("Joe Shmo"));
		mockReturnValues.add(new TechTag("Man Child"));
		mockReturnValues.add(new TechTag("Dickie Betts"));
		
		when(this.ts.getAllTags()).thenReturn(mockReturnValues);
//		when(this.clientDao.getAllClients()).thenReturn(mockReturnValues);
		
		List<TechTag> actual = ts.getAllTags();
		
		//this is whats expected for clients list
		List<TechTag> expected = new ArrayList<>();
		expected.add(new TechTag("Joe Shmo"));
		expected.add(new TechTag("Man Child"));
		expected.add(new TechTag("Dickie Betts"));
		
		assertEquals(expected, actual);
		
	}
	
	



}
