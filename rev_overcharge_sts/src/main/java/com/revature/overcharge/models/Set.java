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

import com.revature.overcharge.models.Card;

@Entity
@Table(name="sets")
public class Set {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="creator_id")
	private int creatorId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="created_on")
	private long createdOn;
	
	@OneToMany
	@JoinColumn(name="set_id")
	private List<Card> flashcards;

	
}
