package com.revature.overcharge.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.repositories.RatingRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class RatingServiceTest {

	@Autowired
	RatingService rs;

	@MockBean
	RatingRepo rr;

	@Test
	public void addRating() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void getRatingByUserIdAndDeckId() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void updateRating() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void deleteRatingByUserIdAndDeckId() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void getRatingsByUserId() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void getRatingsByDeckId() {
		Assertions.assertEquals(0, 0);

	}

}
