package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(RatingId.class)
@Table(name = "ratings")
public class Rating {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Id
    @Column(name = "deck_id")
    private int deckId;

    private int stars;

    @Column(name = "rated_on")
    private Long ratedOn;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(int userId, int deckId, int stars, Long ratedOn) {
		super();
		this.userId = userId;
		this.deckId = deckId;
		this.stars = stars;
		this.ratedOn = ratedOn;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Long getRatedOn() {
		return ratedOn;
	}

	public void setRatedOn(Long ratedOn) {
		this.ratedOn = ratedOn;
	}

	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", deckId=" + deckId + ", stars=" + stars + ", ratedOn=" + ratedOn + "]";
	}

}