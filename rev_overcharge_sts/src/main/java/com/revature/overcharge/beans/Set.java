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

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.beans.User;

@Entity
@Table(name="sets")
public class Set {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User creator;
	
	@Column(name="title")
	private String title;
	
	@Column(name="created_on")
	private long createdOn;
	
	@OneToMany
	@JoinColumn(name="set_id")
	private List<Card> flashcards;

	public Set(User creator, String title, long createdOn, List<Card> flashcards) {
		super();
		this.creator = creator;
		this.title = title;
		this.createdOn = createdOn;
		this.flashcards = flashcards;
	}

	public Set(int id, User creator, String title, long createdOn, List<Card> flashcards) {
		super();
		this.id = id;
		this.creator = creator;
		this.title = title;
		this.createdOn = createdOn;
		this.flashcards = flashcards;
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

	public List<Card> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<Card> flashcards) {
		this.flashcards = flashcards;
	}

	@Override
	public String toString() {
		return "Set [id=" + id + ", creator=" + creator + ", title=" + title + ", createdOn=" + createdOn
				+ ", flashcards=" + flashcards + "]";
	}
	
}
