package com.revature.overcharge.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

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
    private Long createdOn;
    
    @Column(name = "status")
    private int status;

    @Transient
    private Double avgRating;

    @OneToMany(mappedBy = "deck")
    @Transient
    private List<Card> cards;

    public Deck() {
        super();
    }

    public Deck(User creator, String title, Long createdOn, List<Card> cards) {
        super();
        this.creator = creator;
        this.title = title;
        this.createdOn = createdOn;
        this.cards = cards;
    }

    public Deck(int id, User creator, String title, Long createdOn, List<Card> cards) {
        super();
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.createdOn = createdOn;
        this.cards = cards;
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

    public Long getCreatedOn() {
        return createdOn;
    }
    
    public int getStatus() {
    	return status;
    }
    
    public void setStatus(int status) {
    	this.status = status;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck [id=" + id + ", creator=" + creator + ", title=" + title
                + ", createdOn=" + createdOn + ", avgRating=" + avgRating
                +  ", status " + status + "]";
    }

}
