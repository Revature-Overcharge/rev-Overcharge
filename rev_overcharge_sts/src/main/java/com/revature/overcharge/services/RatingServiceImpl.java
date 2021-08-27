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
    
    @Autowired
    ObjectiveService os;

    @Override
    public Rating saveRating(Rating r) {
        r.setRatedOn(new Date().getTime());
        log.info(r.toString());
        r = rr.save(r);
        os.set5StarDeckWeekly(r);
        return r;
    }

    @Override
    public List<Rating> getRatings(Integer userId, Integer deckId) {
        List<Rating> ratings;
        if (userId != null) {
            if (deckId != null) {
                ratings = rr.getByUserIdAndDeckId(userId, deckId);
            } else {
                log.info("Getting by user id");
                ratings = rr.getByUserId(userId);
            }
        } else if (deckId != null) {
            ratings = rr.getByDeckId(deckId);
        } else {
            ratings = (List<Rating>) rr.findAll();
        }
        if (!ratings.isEmpty()) {
            return ratings;
        } else {
            log.warn("User id and/or deck id are not found on any ratings in database");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public boolean deleteRating(RatingId rId) {
        if (rr.existsById(rId)) {
            rr.deleteById(rId);
            return true;
        } else {
            log.warn("User id and deck id are not found on any ratings in database");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

	@Override
	public List<Rating> getAllRatings() {
		return (List<Rating>) rr.findAll();
	}

	@Override
	public List<Rating> getRatingsByDeckId(int deckId) {
		return (List<Rating>) rr.findByDeckId(deckId);
	}

	@Override
	public Rating updateRating(Rating r) {
		return rr.save(r);
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		return rr.getByUserId(userId);
	}

}
