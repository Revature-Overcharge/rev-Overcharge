package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;

    private int stars;

    @Column(name = "ratedOn")
    private long rated_on;

    public Rating() {
        super();
    }

    public Rating(User user, Set set, int stars, long rated_on) {
        super();
        this.user = user;
        this.set = set;
        this.stars = stars;
        this.rated_on = rated_on;
    }

    public Rating(int id, User user, Set set, int stars, long rated_on) {
        super();
        this.id = id;
        this.user = user;
        this.set = set;
        this.stars = stars;
        this.rated_on = rated_on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public long getRated_on() {
        return rated_on;
    }

    public void setRated_on(long rated_on) {
        this.rated_on = rated_on;
    }

    @Override
    public String toString() {
        return "Rating [id=" + id + ", user=" + user + ", set=" + set
                + ", stars=" + stars + ", rated_on=" + rated_on + "]";
    }

}
