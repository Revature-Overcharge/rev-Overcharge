package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deck_id")
	@JsonIgnore
	private Deck deck;

	private String question;

	private String answer;
 
	@Column(name = "created_on")
	private Long createdOn;

	public Card() {
		super();
	}

	public Card(int id, Deck deck, String question, String answer, Long createdOn) {
		super();
		this.id = id;
		this.deck = deck;
		this.question = question;
		this.answer = answer;
		this.createdOn = createdOn;
	}

	public Card(String question, String answer, Long createdOn) {
		super();
		this.question = question;
		this.answer = answer;
		this.createdOn = createdOn;
	}

	public Card(int id, String question, String answer, Long createdOn) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.createdOn = createdOn;
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

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", question=" + question + ", answer=" + answer + ", createdOn="
				+ createdOn + "]";
	}

}
