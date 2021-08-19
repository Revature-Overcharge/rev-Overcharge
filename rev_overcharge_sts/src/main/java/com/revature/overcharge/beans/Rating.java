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
@IdClass(RatingId.class)
@Table(name = "ratings")
public class Rating {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    private int stars;

    @Column(name = "rated_on")
    private long ratedOn;

    public Rating() {
        super();
    }

    public Rating(User user, Deck deck, int stars) {
        super();
        this.user = user;
        this.deck = deck;
        this.stars = stars;
        ratedOn = new Date().getTime();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public long getRatedOn() {
        return ratedOn;
    }

    public void setRatedOn(long ratedOn) {
        this.ratedOn = ratedOn;
    }

    @Override
    public String toString() {
        return "Rating [user=" + user + ", deck=" + deck + ", stars=" + stars
                + ", ratedOn=" + ratedOn + "]";
    }

}