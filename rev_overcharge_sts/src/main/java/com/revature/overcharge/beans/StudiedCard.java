package com.revature.overcharge.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(StudiedCardId.class)
@Table(name = "studied_cards")
public class StudiedCard {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "studied_on")
    private long studiedOn;

    public StudiedCard() {
        super();
    }

    public StudiedCard(User user, Card card) {
        super();
        this.user = user;
        this.card = card;
        studiedOn = new Date().getTime();
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

    public long getStudiedOn() {
        return studiedOn;
    }

    public void setStudiedOn(long studiedOn) {
        this.studiedOn = studiedOn;
    }

    @Override
    public String toString() {
        return "studiedCard [user=" + user + ", card=" + card + ", studiedOn="
                + studiedOn + "]";
    }

}
