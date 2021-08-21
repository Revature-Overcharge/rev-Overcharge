package com.revature.overcharge.beans;

public class CompositeRequest {

    private Integer userId;

    private Integer deckId;

    private Integer cardId;

    private Integer stars;

    public CompositeRequest(Integer userId, Integer deckId, Integer cardId,
            Integer stars) {
        super();
        this.userId = userId;
        this.deckId = deckId;
        this.cardId = cardId;
        this.stars = stars;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

}
