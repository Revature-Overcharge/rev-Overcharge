package com.revature.overcharge.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    @OneToMany(mappedBy = "deck")
    @Transient
    private List<Feedback> feedback;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "deck_tag", 
			joinColumns = { @JoinColumn(name = "deck_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "tag_id") }
	)
    private Set<TechTag> tags = new HashSet<>();

    public Deck() {
        super();
    }

    public Deck(User creator, String title, Long createdOn, List<Card> cards,  Set<TechTag> tags, List<Feedback> feedback) {
        super();
        this.creator = creator;
        this.title = title;
        this.createdOn = createdOn;
        this.cards = cards;
        this.feedback = feedback;
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
    
    
    public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

    public Set<TechTag> getTags() {
		return tags;
	}

	public void setTags(Set<TechTag> tags) {
		this.tags = tags;
	}
	
	public void addTags(TechTag tag) {
		this.tags.add(tag);
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", creator=" + creator + ", title=" + title + ", createdOn=" + createdOn
				+ ", avgRating=" + avgRating + ", cards=" + cards + ", tags=" + tags + "]";
	}
}
