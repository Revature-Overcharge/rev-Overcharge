package com.revature.overcharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.services.ObjectiveService;

@CrossOrigin
@RestController
public class ObjectiveController {

    @Autowired
    ObjectiveService os;

    @GetMapping(value = "/users/{id}/objectives")
    public User getAllObjectivesForUser(
            @PathVariable("id") String id) {
        return os.getAllObjectivesForUser(Integer.parseInt(id));
    }

}
