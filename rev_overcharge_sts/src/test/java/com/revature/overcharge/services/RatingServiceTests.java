package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;
import com.revature.overcharge.repositories.RatingRepo;

@SpringBootTest(
        classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class RatingServiceTests {

    @Autowired
    public RatingService rs;
    
    @MockBean
    public RatingRepo rr;

    @Test
    void saveRatingAddPass() {
        // This rating doesn't exist yet in the database
        Rating ratingToAdd = new Rating(2, 1, 1, null);
        String rToAddStr = ratingToAdd.toString();

        Rating addedRating = rs.saveRating(ratingToAdd);
        assertNotNull(addedRating);

        addedRating.setRatedOn(null);
        assertEquals(rToAddStr, addedRating.toString());
    }

//     @Test
//     void saveRatingUpdatePass() {
//         // This rating already exists in the database
//         Rating ratingToUpdate = rs.getRatings(1, 1).get(0);
//         ratingToUpdate.setRatedOn(null);
//         String rToUpdateStr = ratingToUpdate.toString();

//         ratingToUpdate.setStars(1);
//         Rating updatedRating = rs.saveRating(ratingToUpdate);
//         assertNotNull(updatedRating.getRatedOn());

//         updatedRating.setRatedOn(null);
//         assertNotEquals(rToUpdateStr, updatedRating.toString());
//     }

    @Test
    void getRatingsByUserIdAndDeckIdPass() {
        Rating ratingObj = new Rating(2, 1, 1, null);
        List<Rating> ratingObjList = new ArrayList<>();
        ratingObjList.add(rs.saveRating(ratingObj));
        assertEquals(ratingObjList.get(0), ratingObj);
    }
    
    @Test
    void getRatingsByUserIdAndDeckIdFail() {
    	List<Rating> ratingObjList = new ArrayList<>();
        ratingObjList = rs.getRatings(100, 100);
        
        Assertions.assertNotNull(ratingObjList);
    }

    @Test
    void getRatingsByUserIdPass() {
        assertNotNull(rs.getRatings(8, null));
    }
    
    @Test
    void getRatingsByUserIdFail() {
    	List<Rating> ratingObjList = new ArrayList<>();
        ratingObjList = rs.getRatings(100, null);
        Assertions.assertNotNull(ratingObjList);
    }

    @Test
    void getRatingsByDeckIdPass() {
        assertEquals(0, rs.getRatings(null, 2).size());
    }
    
    @Test
    void getRatingsByDeckIdFail() {
    	List<Rating> ratingObjList = new ArrayList<>();
        ratingObjList = rs.getRatings(null, 100);
        
        Assertions.assertNotNull(ratingObjList);
        
    }

    @Test
    void getAllRatingsPass() {
        assertNotNull(rs.getRatings(null, null));
    }

    @Test
    void deleteRatingTestPass() {
        RatingId ratingIdObj = new RatingId(1, 1);
        
        Mockito.when(rr.existsById(ratingIdObj)).thenReturn(true);
        assertTrue(rs.deleteRating(ratingIdObj));
    }

    @Test
    void deleteRatingTestFail() {
        RatingId ratingIdObj = new RatingId(100, 100);
        assertThrows(ResponseStatusException.class, () -> {
            rs.deleteRating(ratingIdObj);
        });
    }
}
