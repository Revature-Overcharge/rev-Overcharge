package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;
import com.revature.overcharge.repositories.StudiedCardRepo;

@Service
public class StudiedCardServiceImpl implements StudiedCardService {

    private static final Logger log = Logger
            .getLogger(StudiedCardServiceImpl.class);

    @Autowired
    StudiedCardRepo scr;

    @Autowired
    UserService us;

    @Autowired
    CardService cs;

    @Override
    public StudiedCard addStudiedCard(StudiedCard sc) {
        if (scr.existsByUserIdAndCardId(sc.getUserId(), sc.getCardId())) {
            log.warn("This card is already marked as studied by this user");
            return null;
        } else {
            sc.setStudiedOn(new Date().getTime());
            log.info(sc.toString());
            return scr.save(sc);
        }
    }

    @Override
    public List<StudiedCard> getStudiedCards(Integer userId, Integer cardId) {
        if (userId != null) {
            if (cardId != null) {
                return scr.getByUserIdAndCardId(userId, cardId);
            } else {
                return scr.getByUserId(userId);
            }
        } else if (cardId != null) {
            return scr.getByCardId(cardId);
        } else {
            return (List<StudiedCard>) scr.findAll();
        }
    }

    @Override
    public boolean deleteStudiedCard(StudiedCardId scId) {
        if (scr.existsById(scId)) {
            scr.deleteById(scId);
            return true;
        } else {
            log.warn("userId and cardId are invalid for delete");
            return false;
        }
    }

}
