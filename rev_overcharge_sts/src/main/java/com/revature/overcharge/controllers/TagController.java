package com.revature.overcharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.services.TagService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class TagController {
	@Autowired
	TagService ts;
	
	@GetMapping(value = "/tags", produces = "application/json")
	public ResponseEntity<Object> getAllTags(){
		return ResponseEntity.status(200).body(ts.getAllTags());
	}
	

}
