package com.revature.overcharge.beans;

import java.util.Objects;

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
@Table(name = "feedbacks")
public class Feedback {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deck_id")
	@JsonIgnore
	private Deck deck;
	
	@Column(name = "created_on")
	private Long createdOn;
	
	@Column(name = "content")
	private String content;

	
	
	public Feedback() {
		super();
	}

	
	
	public Feedback(int id, Deck deck, Long createdOn, String content) {
		super();
		this.id = id;
		this.deck = deck;
		this.createdOn = createdOn;
		this.content = content;
	}

	public Feedback(Deck deck, Long createdOn, String content) {
		super();
		this.deck = deck;
		this.createdOn = createdOn;
		this.content = content;
	}

	public Feedback(Long createdOn, String content) {
		super();
		this.createdOn = createdOn;
		this.content = content;
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



	public Long getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public int hashCode() {
		return Objects.hash(content, createdOn, deck, id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(content, other.content) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(deck, other.deck) && id == other.id;
	}



	@Override
	public String toString() {
		return "Feedback [id=" + id + ", deck=" + deck + ", createdOn=" + createdOn + ", content=" + content + "]";
	}



	
}
