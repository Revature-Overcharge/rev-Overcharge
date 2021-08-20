package com.revature.overcharge.beans;

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

    private Integer stars;

    @Column(name = "rated_on")
    private Long ratedOn;

    public Rating() {
        super();
    }

    public Rating(User user, Deck deck, Integer stars, Long ratedOn) {
        super();
        this.user = user;
        this.deck = deck;
        this.stars = stars;
        this.ratedOn = ratedOn;
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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Long getRatedOn() {
        return ratedOn;
    }

    public void setRatedOn(Long ratedOn) {
        this.ratedOn = ratedOn;
    }

    @Override
    public String toString() {
        return "Rating [user=" + user + ", deck=" + deck + ", stars=" + stars
                + ", ratedOn=" + ratedOn + "]";
    }

}