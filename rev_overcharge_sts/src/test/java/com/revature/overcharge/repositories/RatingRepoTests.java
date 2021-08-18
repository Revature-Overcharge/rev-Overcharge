package com.revature.overcharge.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class RatingRepoTests {
    
    @Autowired
    public RatingRepo rr;
    
    @Test
    void addRating() {
        
    }
    
}
