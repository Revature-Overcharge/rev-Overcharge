package com.revature.overcharge.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="set_id")
	private int setId;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="created_on")
	private long createdOn;

	public Card(int setId, String question, String answer, long createdOn) {
		super();
		this.setId = setId;
		this.question = question;
		this.answer = answer;
		this.createdOn = createdOn;
	}
	
	public Card(int id, int setId, String question, String answer, long createdOn) {
		super();
		this.id = id;
		this.setId = setId;
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

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", setId=" + setId + ", question=" + question + ", answer=" + answer + ", createdOn="
				+ createdOn + "]";
	}
	
}
