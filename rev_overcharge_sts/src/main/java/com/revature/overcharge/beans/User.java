package com.revature.overcharge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="objective_points")
	private int points;
	
	@Column(name="last_login_on")
	private long lastLogin;

	public User(String username, String password, int points, long lastLogin) {
		super();
		this.username = username;
		this.password = password;
		this.points = points;
		this.lastLogin = lastLogin;
	}

	public User(int id, String username, String password, int points, long lastLogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.points = points;
		this.lastLogin = lastLogin;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", points=" + points
				+ ", lastLogin=" + lastLogin + "]";
	}
	
}
