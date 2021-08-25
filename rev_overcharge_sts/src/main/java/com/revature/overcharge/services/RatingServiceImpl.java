package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;
import com.revature.overcharge.repositories.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

    private static final Logger log = Logger.getLogger(RatingServiceImpl.class);

    @Autowired
    RatingRepo rr;

    @Override
    public Rating saveRating(Rating r) {
        r.setRatedOn(new Date().getTime());
        log.info(r.toString());
        return rr.save(r);
    }

    @Override
    public List<Rating> getRatings(Integer userId, Integer deckId) {
        if (userId != null) {
            if (deckId != null) {
                return rr.getByUserIdAndDeckId(userId, deckId);
            } else {
                return rr.getByUserId(userId);
            }
        } else if (deckId != null) {
            return rr.getByDeckId(deckId);
        } else {
            return (List<Rating>) rr.findAll();
        }
    }

    @Override
    public boolean deleteRating(RatingId rId) {
        if (rr.existsById(rId)) {
            rr.deleteById(rId);
            return true;
        } else {
            log.warn("userId and cardId are invalid for delete");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
