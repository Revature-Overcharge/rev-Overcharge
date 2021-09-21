package com.revature.overcharge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;
import com.revature.overcharge.services.StudiedCardService;

@CrossOrigin
@RestController
public class StudiedCardController {

    private static final Logger log = LoggerFactory.getLogger(StudiedCardController.class);

    @Autowired
    StudiedCardService scs;

    @PostMapping(value = "/studied_cards", consumes = "application/json",
            produces = "application/json")
    public StudiedCard addStudiedCard(@RequestBody StudiedCard sc) {
        log.info("Adding studied card");
        return scs.addStudiedCard(sc);
    }

    @GetMapping(value = "/studied_cards")
    public List<StudiedCard> getStudiedCards(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer cardId) {
        return scs.getStudiedCards(userId, cardId);
    }

    @DeleteMapping(value = "/studied_cards")
    public boolean deleteStudiedCard(@RequestBody StudiedCardId scId) {
        return scs.deleteStudiedCard(scId);
    }

}
