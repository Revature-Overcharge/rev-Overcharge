package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@IdClass(StudiedCardId.class)
@Table(name = "studied_cards")
public class StudiedCard {

    private static final Logger log = Logger.getLogger(StudiedCard.class);

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "studied_on")
    private Long studiedOn;

    public StudiedCard() {
        super();
    }

    public StudiedCard(User user, Card card, Long studiedOn) {
        super();
        log.info("In StudiedCard constructor");
        this.user = user;
        this.card = card;
        this.studiedOn = studiedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getStudiedOn() {
        return studiedOn;
    }

    public void setStudiedOn(Long studiedOn) {
        this.studiedOn = studiedOn;
    }

    @Override
    public String toString() {
        return "studiedCard [user=" + user + ", card=" + card + ", studiedOn="
                + studiedOn + "]";
    }

}
