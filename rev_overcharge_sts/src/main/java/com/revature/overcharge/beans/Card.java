package com.revature.overcharge.beans;

import java.util.Date;
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

import com.revature.overcharge.beans.Set;

@Entity
@Table(name="cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="set_id")
	private Set set;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="created_on")
	private long createdOn;

	public Card(Set set, String question, String answer, long createdOn) {
		super();
		this.set = set;
		this.question = question;
		this.answer = answer;
		this.createdOn = createdOn;
	}

	public Card(int id, Set set, String question, String answer, long createdOn) {
		super();
		this.id = id;
		this.set = set;
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

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", set=" + set + ", question=" + question + ", answer=" + answer + ", createdOn="
				+ createdOn + "]";
	}
	
}
