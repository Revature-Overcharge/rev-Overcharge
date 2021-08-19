package com.revature.overcharge.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "decks")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private String title;

    @Column(name = "created_on")
    private long createdOn;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deck")
    @Transient
    private List<Card> cards;

    @OneToMany(mappedBy = "deck")
    @JsonIgnore
    @Transient
    private List<Rating> ratings;

    public Deck() {
        super();
    }

    public Deck(User creator, String title) {
        super();
        this.creator = creator;
        this.title = title;
        createdOn = new Date().getTime();
    }

    public Deck(int id, User creator, String title) {
        super();
        this.id = id;
        this.creator = creator;
        this.title = title;
        createdOn = new Date().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Deck [id=" + id + ", creator=" + creator + ", title=" + title
                + ", createdOn=" + createdOn + "]";
    }

}
