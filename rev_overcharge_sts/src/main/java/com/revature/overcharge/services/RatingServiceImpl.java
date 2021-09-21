package com.revature.overcharge.services;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.Rating;
import com.revature.overcharge.beans.RatingId;
import com.revature.overcharge.repositories.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

    private static final Logger log = LoggerFactory.getLogger(RatingServiceImpl.class);

    private static final DecimalFormat df = new DecimalFormat("#.##");

    @Autowired
    RatingRepo rr;

    @Autowired
    UserService us;

    @Autowired
    DeckService ds;

    @Autowired
    ObjectiveService os;

    @Override
    public Rating saveRating(Rating r) {
        if (r.getUserId() == ds.getDeck(r.getDeckId()).getCreator().getId()) {
            log.warn("User can't rate their own deck.");
            return r;
        }
        r.setRatedOn(new Date().getTime());
        log.info(r.toString());
        
        List<Rating> userRatings = getRatings(r.getUserId(), null);

        for (Rating rating : userRatings) {
            if (rating.getDeckId() == r.getDeckId() && rating.getUserId() == r.getUserId()) {
            	return r;
            }
        }
        
        r = rr.save(r);
        os.setRateADeckDaily(r.getUserId());
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
                ratings = rr.getByUserId(userId);
            }
        } else if (deckId != null) {
            ratings = rr.getByDeckId(deckId);
        } else {
            ratings = (List<Rating>) rr.findAll();
        }
        return ratings;
    }

    @Override
    public boolean deleteRating(RatingId rId) {
        if (rr.existsById(rId)) {
            rr.deleteById(rId);
            return true;
        } else {
            log.warn(
                    "User id and deck id are not found on any ratings in database");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Rating updateRating(Rating r) {
        return rr.save(r);
    }

    @Override
    public Double calculateAvgRating(int deckId) {
        List<Rating> deckRatings = getRatings(null, deckId);
        double sum = 0.0;
        if (deckRatings.isEmpty())
            return 0.0;
        for (Rating rating : deckRatings) {
            sum += rating.getStars();
        }
        return Math.round((sum * 100 / deckRatings.size())) / 100.0;
    }

}
