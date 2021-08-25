package com.revature.overcharge.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class RatingServiceTests {

	@Autowired
	public RatingService rs;

	@Test
	void saveRatingTestPass() {
		Rating ratingObj1 = new Rating(1, 1, 1, null);
		ratingObj1 = rs.saveRating(ratingObj1);
		Rating ratingObj2 = new Rating(1, 1, 1, null);
		ratingObj2 = rs.saveRating(ratingObj2);
		assertEquals(ratingObj1.getStars(), ratingObj2.getStars());
		ratingObj1 = rs.saveRating(new Rating(1, 1, 5, null));
		assertNotEquals(ratingObj1.getStars(), ratingObj2.getStars());
	}

	@Test
	void getRatingsTestPass() {
		Rating ratingObj = new Rating(1, 1, 1, null);
		List<Rating> ratingObjList = new ArrayList<Rating>();
		ratingObjList.add(rs.saveRating(ratingObj));
		assertEquals(ratingObjList, rs.getRatings(1, 1));	
	}

	@Test
	void getRatingsTestFail() {
		Rating ratingObj1 = new Rating(1, 1, 1, null);
		rs.saveRating(ratingObj1);
		Rating ratingObj2 = new Rating(1, 1, 5, null);
		List<Rating> ratingObjList = new ArrayList<Rating>();
		ratingObjList.add(ratingObj1);
		ratingObjList.add(ratingObj2);
		assertNotEquals(ratingObjList, rs.getRatings(1, 1));	
	}

	@Test
	void deleteRatingTestPass() {
		RatingId ratingIdObj = new RatingId(1, 1);
		assertEquals(true, rs.deleteRating(ratingIdObj));
	}

	@Test
	void deleteRatingTestFail() {
		RatingId ratingIdObj = new RatingId();
		assertThrows(ResponseStatusException.class, () -> {
			rs.deleteRating(ratingIdObj);
        });
	}
}