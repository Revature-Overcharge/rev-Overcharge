package com.revature.overcharge.beans;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class StudiedCardId implements Serializable {

    private User user;

    private Card card;

    public StudiedCardId() {
        super();
    }

    public StudiedCardId(User user, Card card) {
        super();
        this.user = user;
        this.card = card;
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudiedCardId other = (StudiedCardId) obj;
        return Objects.equals(card, other.card)
                && Objects.equals(user, other.user);
    }

}
