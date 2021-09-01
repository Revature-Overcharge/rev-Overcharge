package com.revature.overcharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.services.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService us;

	@CrossOrigin
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User u) {
		return us.addUser(u);
	}

	@CrossOrigin
	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		return us.getUser(id);
	}

	@CrossOrigin
	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}

	@CrossOrigin
	@PutMapping(value = "/users/{id}", consumes = "application/json", produces = "application/json")
	public User updateUser(@PathVariable int id, @RequestBody User newUser) {
		newUser.setId(id);
		return us.updateUser(newUser);
	}

	@CrossOrigin
	@DeleteMapping(value = "/users/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return us.deleteUser(id);
	}

	@CrossOrigin
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public User login(@RequestBody User u) {
		return us.login(u);
	}
}
