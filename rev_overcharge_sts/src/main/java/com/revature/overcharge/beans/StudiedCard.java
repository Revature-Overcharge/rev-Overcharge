package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studied_cards")
public class StudiedCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "studied_on")
    private long studiedOn;

    public StudiedCard() {
        super();
    }

    public StudiedCard(User user, Card card, long studiedOn) {
        super();
        this.user = user;
        this.card = card;
        this.studiedOn = studiedOn;
    }

    public StudiedCard(int id, User user, Card card, long studiedOn) {
        super();
        this.id = id;
        this.user = user;
        this.card = card;
        this.studiedOn = studiedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "studiedCard [id=" + id + ", user=" + user + ", card=" + card
                + ", studiedOn=" + studiedOn + "]";
    }

}
