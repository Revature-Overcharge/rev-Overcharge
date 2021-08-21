package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.CompositeRequest;
import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.User;
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
    public StudiedCard addStudiedCard(CompositeRequest compReq) {
        if (scr.existsByUserIdAndCardId(compReq.getUserId(),
                compReq.getCardId())) {
            log.warn("This card is already marked as studied by this user");
            return null;
        } else {
            User user = us.getUser(compReq.getUserId());
            Card card = cs.getCard(compReq.getCardId());
            log.info("Creating new StudiedCard object");
            StudiedCard sc = new StudiedCard(user, card, new Date().getTime());
            log.info("Done creating StudiedCard object");
            log.info(sc.toString());
            return scr.save(sc);
        }
    }

    @Override
    public List<StudiedCard> getStudiedCards(Integer userId, Integer cardId) {
        if (userId != null) {
            if (cardId != null) {
                return scr.findByUserIdAndCardId(userId, cardId);
            } else {
                return scr.findByUserId(userId);
            }
        } else if (cardId != null) {
            return scr.findByCardId(cardId);
        } else {
            return (List<StudiedCard>) scr.findAll();
        }
    }

    @Override
    public StudiedCard updateStudiedCard(StudiedCard newSc) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteStudiedCard(int userId, int cardId) {
        // TODO Auto-generated method stub
        return false;
    }

}
