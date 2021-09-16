package com.revature.overcharge.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int id;

	private String username;

	private String password;

	private Integer points;

	private int role;

	@Column(name = "last_login")
	private Long lastLogin;

	@OneToMany(mappedBy = "creator")
	@JsonIgnore
	@Transient
	private List<Deck> createdDecks;

	@OneToMany(mappedBy = "user")
	@Transient
	private List<Objective> objectives = new ArrayList<Objective>();

	public User() {
		super();
	}

	public User(String username, String password, Integer points, int role, Long lastLogin) {
		super();
		this.username = username;
		this.password = password;
		this.points = points;
		this.role = role;
		this.lastLogin = lastLogin;
	}

	public User(int id, String username, String password, Integer points, int role, Long lastLogin) { 
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.points = points;
		this.role = role;
		this.lastLogin = lastLogin;
	}

	public User(int id, String username, String password, Integer points, Long lastLogin, int role, List<Objective> objectives) { 
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.points = points;
		this.role = role;
		this.lastLogin = lastLogin;
		this.objectives = objectives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Deck> getCreatedDecks() {
		return createdDecks;
	}

	public void setCreatedDecks(List<Deck> createdDecks) {
		this.createdDecks = createdDecks;
	}

	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", points=" + points + ", role="+ role + ", lastLogin=" + lastLogin + "]";
	}

}
