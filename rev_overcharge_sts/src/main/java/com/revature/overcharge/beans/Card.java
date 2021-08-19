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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private Deck deck;

    private String question;

    private String answer;

    @Column(name = "created_on")
    private long createdOn;

    @OneToMany(mappedBy = "card")
    @JsonIgnore
    @Transient
    private List<StudiedCard> studiedCards;

    public Card() {
        super();
    }

    public Card(Deck deck, String question, String answer) {
        super();
        this.deck = deck;
        this.question = question;
        this.answer = answer;
        createdOn = new Date().getTime();
    }

    public Card(int id, Deck deck, String question, String answer) {
        super();
        this.id = id;
        this.deck = deck;
        this.question = question;
        this.answer = answer;
        createdOn = new Date().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public List<StudiedCard> getStudiedCards() {
        return studiedCards;
    }

    public void setStudiedCards(List<StudiedCard> studiedCards) {
        this.studiedCards = studiedCards;
    }

    @Override
    public String toString() {
        return "Card [id=" + id + ", deck=" + deck + ", question=" + question
                + ", answer=" + answer + ", createdOn=" + createdOn + "]";
    }

}
