package com.revature.overcharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Objective;
import com.revature.overcharge.services.ObjectiveService;

@CrossOrigin
@RestController
public class ObjectiveController {

    @Autowired
    ObjectiveService os;

    @GetMapping(value = "/users/{id}/objectives")
    public List<Objective> getAllObjectivesForUser(
            @PathVariable("id") String id) {
        return os.getAllObjectivesForUser(Integer.parseInt(id));
    }

}
