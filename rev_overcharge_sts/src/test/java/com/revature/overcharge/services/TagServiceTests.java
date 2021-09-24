package com.revature.overcharge.services;

import static org.mockito.ArgumentMatchers.any;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
import com.revature.overcharge.dto.DeckTagsDTO;
import com.revature.overcharge.repositories.CardRepo;
import com.revature.overcharge.repositories.DeckRepo;
import com.revature.overcharge.repositories.TagRepo;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TagServiceTests {

	
	
	@Mock
	TagRepo tr;
	
	@Mock
	DeckRepo dr;
	
	@InjectMocks
	public DeckServiceImpl ds;
	
	@InjectMocks
	public TagServiceImpl ts;
	
	private AutoCloseable closeable;

	
	@BeforeEach
	void setUp() throws Exception {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		 closeable.close();
	}


	

//	@BeforeEach
//	public void setUp() throws Exception {
//		this.tr = mock(TagRepo.class); //using mockito to creat fake ship doa object
//		
//		this.ts = new TagServiceImpl(tr); //injecting mocked object into shipservice object
//		
//		this.dr = mock(DeckRepo.class);
//		
//		this.ds = new DeckServiceImpl(dr, tr);
//		
//	}
	
	
	
	@Test
	public void test_getAllTags_positive() throws SQLException {

		List<TechTag> mockReturnValues = new ArrayList<>();
		mockReturnValues.add(new TechTag("Joe Shmo"));
		mockReturnValues.add(new TechTag("Man Child"));
		mockReturnValues.add(new TechTag("Dickie Betts"));
		
		when(this.tr.findAll()).thenReturn(mockReturnValues);
		
		List<TechTag> actual = ts.getAllTags();
		
		List<TechTag> expected = new ArrayList<>();
		expected.add(new TechTag("Joe Shmo"));
		expected.add(new TechTag("Man Child"));
		expected.add(new TechTag("Dickie Betts"));
		
		assertEquals(expected, actual);
		
	}
	
	
	
	
	
	
	
	@Test
	public void test_setDeckTags_positive() throws SQLException {	
		
		DeckTagsDTO dto = new DeckTagsDTO();
		
		List<Integer> mockReturnValues = new ArrayList<>();
		mockReturnValues.add(1);
		
		dto.setTagsId(mockReturnValues);
		
		Deck deck = new Deck();
						
		
		TechTag tt = new TechTag("Maven");		
		tt.setId(1);
		
		when(this.dr.findById(0)).thenReturn(deck);		
		when(this.tr.getById(1)).thenReturn(tt);
			
		
		tt.addDeck(deck);
		deck.addTags(tt);
		tr.save(tt);
	
		dr.save(deck);
				
		Deck actual = ds.setDeckTags(0, dto);
		
		assertEquals(deck, actual);
	}
	
	
	


}
