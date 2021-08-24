package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(StudiedCardId.class)
@Table(name = "studied_cards")
public class StudiedCard {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Id
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "studied_on")
    private Long studiedOn;

    public StudiedCard() {
        super();
    }

    public StudiedCard(int userId, int cardId, Long studiedOn) {
        super();
        this.userId = userId;
        this.cardId = cardId;
        this.studiedOn = studiedOn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Long getStudiedOn() {
        return studiedOn;
    }

    public void setStudiedOn(Long studiedOn) {
        this.studiedOn = studiedOn;
    }

    @Override
    public String toString() {
        return "StudiedCard [userId=" + userId + ", cardId=" + cardId
                + ", studiedOn=" + studiedOn + "]";
    }

}
