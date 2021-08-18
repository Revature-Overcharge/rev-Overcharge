package com.revature.overcharge.beans;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class RatingId implements Serializable {

    private User user;

    private Deck deck;

    public RatingId() {
        super();
    }

    public RatingId(User user, Deck deck) {
        super();
        this.user = user;
        this.deck = deck;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deck, user);
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
        return Objects.equals(deck, other.deck)
                && Objects.equals(user, other.user);
    }

}
