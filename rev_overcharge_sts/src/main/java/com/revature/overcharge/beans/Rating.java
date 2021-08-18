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
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    private int stars;

    @Column(name = "ratedOn")
    private long rated_on;

    public Rating() {
        super();
    }

    public Rating(User user, Deck deck, int stars, long rated_on) {
        super();
        this.user = user;
        this.deck = deck;
        this.stars = stars;
        this.rated_on = rated_on;
    }

    public Rating(int id, User user, Deck deck, int stars, long rated_on) {
        super();
        this.id = id;
        this.user = user;
        this.deck = deck;
        this.stars = stars;
        this.rated_on = rated_on;
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

    public long getRated_on() {
        return rated_on;
    }

    public void setRated_on(long rated_on) {
        this.rated_on = rated_on;
    }

    @Override
    public String toString() {
        return "Rating [id=" + id + ", user=" + user + ", deck=" + deck
                + ", stars=" + stars + ", rated_on=" + rated_on + "]";
    }

}