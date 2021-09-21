package com.revature.overcharge.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tags")
@JsonIgnoreProperties(value = { "decks" })
public class TechTag {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int id;
	
	@Column (name = "tag")
	private String tag;
	
	@ManyToMany(mappedBy = "tags")
    private Set<Deck> decks = new HashSet<>();
	

	public TechTag() {
		super();
	}
	
	
	public TechTag(String tag) {
		this.tag = tag;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<Deck> getDecks() {
		return decks;
	}

	public void setDecks(Set<Deck> decks) {
		this.decks = decks;
	}
	
	public void addDeck(Deck deck) {
		this.decks.add(deck);
	}


	@Override
	public String toString() {
		return "TechTag [id=" + id + ", tag=" + tag + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decks == null) ? 0 : decks.hashCode());
		result = prime * result + id;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TechTag other = (TechTag) obj;
		if (decks == null) {
			if (other.decks != null) {
				return false;
			}
		} else if (!decks.equals(other.decks)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (tag == null) {
			if (other.tag != null) {
				return false;
			}
		} else if (!tag.equals(other.tag)) {
			return false;
		}
		return true;
	}
	
	

}
