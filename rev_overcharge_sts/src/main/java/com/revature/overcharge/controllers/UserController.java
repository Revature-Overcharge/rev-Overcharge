package com.revature.overcharge.controllers;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.exception.BadParameterException;
import com.revature.overcharge.services.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	private HttpServletRequest request;

	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User u) {
		return us.addUser(u);
	}

	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		return us.getUser(id);
	}

	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}

	@PutMapping(value = "/users/{id}", consumes = "application/json", produces = "application/json")
	public User updateUser(@PathVariable int id, @RequestBody User newUser) {
		newUser.setId(id);
		return us.updateUser(newUser);
	}

	@DeleteMapping(value = "/users/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return us.deleteUser(id);
	}

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody User u) {

		try {
			User user = this.us.login(u.getUsername(), u.getPassword());

			HttpSession session = request.getSession(true);

			if (session.getAttribute("currentUser") != null) {
				return ResponseEntity.status(400).body("You are already logged in!");
			}

			session.setAttribute("currentUser", user);
			return ResponseEntity.status(200).body(user);
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PostMapping(value = "/logout")
	public ResponseEntity<Object> logout() {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("currentUser") == null) {
			return ResponseEntity.status(400).body("You are not logged in!");
		}

		session.invalidate();
		return ResponseEntity.status(200).body("You have logged out successfully");
	}
}
