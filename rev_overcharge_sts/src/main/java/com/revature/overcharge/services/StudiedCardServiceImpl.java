package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;
import com.revature.overcharge.repositories.StudiedCardRepo;

@Service
public class StudiedCardServiceImpl implements StudiedCardService {

    private static final Logger log = LoggerFactory.getLogger(StudiedCardServiceImpl.class);

    @Autowired
    StudiedCardRepo scr;

    @Autowired
    UserService us;

    @Autowired
    CardService cs;
    
    @Autowired
    ObjectiveService os;

    @Override
    public StudiedCard addStudiedCard(StudiedCard sc) {
        if (scr.existsByUserIdAndCardId(sc.getUserId(), sc.getCardId())) {
            log.warn("This card is already marked as studied by this user");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            sc.setStudiedOn(new Date().getTime());
            log.info(sc.toString());
            sc = scr.save(sc);
            os.setMarkFiveCardsDaily(sc.getUserId());
            os.setMarkAllCardsInDeckStudiedWeekly(sc.getUserId());
            return sc;
        }
    }

    @Override
    public List<StudiedCard> getStudiedCards(Integer userId, Integer cardId) {
        List<StudiedCard> studiedCards;
        if (userId != null) {
            if (cardId != null) {
                studiedCards = scr.getByUserIdAndCardId(userId, cardId);
            } else {
                studiedCards = scr.getByUserId(userId);
            }
        } else if (cardId != null) {
            studiedCards = scr.getByCardId(cardId);
        } else {
            studiedCards = (List<StudiedCard>) scr.findAll();
        }
        if (!studiedCards.isEmpty()) {
            return studiedCards;
        } else {
            log.warn("User id and/or card id are not found on any ratings in database");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public boolean deleteStudiedCard(StudiedCardId scId) {
        if (scr.existsById(scId)) {
            scr.deleteById(scId);
            return true;
        } else {
            log.warn("User id and card id are invalid for delete");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

	@Override
	public List<StudiedCard> getStudiedCardsByUser(Integer userId) {
		return scr.getByUserId(userId);
	}

	@Override
	public StudiedCard updateCard(StudiedCard sc) {
		return scr.save(sc);
	}

}
