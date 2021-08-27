package com.revature.overcharge.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;

@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class RatingServiceTests {

    @Autowired
    public RatingService rs;

    @Test
    void saveRatingAddPass() {
        // This rating doesn't exist yet in the database
        Rating ratingToAdd = new Rating(2, 1, 1, null);
        String rToAddStr = ratingToAdd.toString();

        Rating addedRating = rs.saveRating(ratingToAdd);
        assertNotNull(addedRating.getRatedOn());

        addedRating.setRatedOn(null);
        assertEquals(rToAddStr, addedRating.toString());
    }

    @Test
    void saveRatingUpdatePass() {
        // This rating already exists in the database
        Rating ratingToUpdate = rs.getRatings(1, 1).get(0);
        ratingToUpdate.setRatedOn(null);
        String rToUpdateStr = ratingToUpdate.toString();

        ratingToUpdate.setStars(1);
        Rating updatedRating = rs.saveRating(ratingToUpdate);
        assertNotNull(updatedRating.getRatedOn());

        updatedRating.setRatedOn(null);
        assertNotEquals(rToUpdateStr, updatedRating.toString());
    }

    @Test
    void getRatingsByUserIdAndDeckIdPass() {
        Rating ratingObj = new Rating(2, 1, 1, null);
        List<Rating> ratingObjList = new ArrayList<>();
        ratingObjList.add(rs.saveRating(ratingObj));
        assertEquals(ratingObjList, rs.getRatings(2, 1));
    }
    
    @Test
    void getRatingsByUserIdAndDeckIdFail() {
        assertThrows(ResponseStatusException.class, () -> {
            rs.getRatings(100, 100);
        });
    }

    @Test
    void getRatingsByUserIdPass() {
        assertEquals(2, rs.getRatings(8, null).size());
    }
    
    @Test
    void getRatingsByUserIdFail() {
        assertThrows(ResponseStatusException.class, () -> {
            rs.getRatings(100, null);
        });
    }

    @Test
    void getRatingsByDeckIdPass() {
        assertEquals(3, rs.getRatings(null, 2).size());
    }
    
    @Test
    void getRatingsByDeckIdFail() {
        assertThrows(ResponseStatusException.class, () -> {
            rs.getRatings(null, 100);
        });
    }

    @Test
    void getAllRatingsPass() {
        assertEquals(9, rs.getRatings(null, null).size());
    }

    @Test
    void deleteRatingTestPass() {
        RatingId ratingIdObj = new RatingId(1, 1);
        assertTrue(rs.deleteRating(ratingIdObj));
    }

    @Test
    void deleteRatingTestFail() {
        RatingId ratingIdObj = new RatingId(2, 2);
        assertThrows(ResponseStatusException.class, () -> {
            rs.deleteRating(ratingIdObj);
        });
    }
}