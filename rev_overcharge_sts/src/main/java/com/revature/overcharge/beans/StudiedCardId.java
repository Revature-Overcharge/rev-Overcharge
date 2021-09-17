package com.revature.overcharge.beans;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class StudiedCardId implements Serializable {

	private int userId;

	private int cardId;

	public StudiedCardId(int userId, int cardId) {
		super();
		this.userId = userId;
		this.cardId = cardId;
	}

	public StudiedCardId() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public int getCardId() {
		return cardId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardId, userId);
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
		return cardId == other.cardId && userId == other.userId;
	}

}
