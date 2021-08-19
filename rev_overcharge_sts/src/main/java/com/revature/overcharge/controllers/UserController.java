package com.revature.overcharge.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") String id) {
        return us.getUser(Integer.parseInt(id));
    }
    
    @GetMapping(value = "/users")
    public User getUserByUname(@PathParam("username") String username) {
        return us.getUserByUname(username);
    }

    @PostMapping(value = "/users", consumes = "application/json",
            produces = "application/json")
    public User addUser(@RequestBody User u) {
        return us.addUser(u);
    }

    @PutMapping(value = "/users/{id}", consumes = "application/json",
            produces = "application/json")
    public User updateUser(@PathVariable int id, @RequestBody User newUser) {
        newUser.setId(id);
        return us.updateUser(newUser);
    }

	
}
