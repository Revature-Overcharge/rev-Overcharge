package com.revature.overcharge.beans;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class RatingId implements Serializable {

    private int userId;

    private int deckId;

    public RatingId() {
        super();
    }

    public RatingId(int userId, int deckId) {
        super();
        this.userId = userId;
        this.deckId = deckId;
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

    @Override
    public int hashCode() {
        return Objects.hash(deckId, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RatingId other = (RatingId) obj;
        return deckId == other.deckId && userId == other.userId;
    }

}
