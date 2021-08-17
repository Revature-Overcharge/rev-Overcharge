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
@Table(name = "finished_cards")
public class FinishedCard {

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

    @Column(name = "finished_on")
    private long finishedOn;

    public FinishedCard() {
        super();
    }

    public FinishedCard(User user, Card card, long finishedOn) {
        super();
        this.user = user;
        this.card = card;
        this.finishedOn = finishedOn;
    }

    public FinishedCard(int id, User user, Card card, long finishedOn) {
        super();
        this.id = id;
        this.user = user;
        this.card = card;
        this.finishedOn = finishedOn;
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

    public long getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(long finishedOn) {
        this.finishedOn = finishedOn;
    }

    @Override
    public String toString() {
        return "FinishedCard [id=" + id + ", user=" + user + ", card=" + card
                + ", finishedOn=" + finishedOn + "]";
    }

}
