package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.beans.TechTag;
import com.revature.overcharge.repositories.TagRepo;

@Service
public class TagServiceImpl implements TagService {
	
	private static final Logger log = Logger.getLogger(TagServiceImpl.class);
	
	@Autowired
	TagRepo tr;
	
	@Override
    public List<TechTag> getAllTags() {
    	System.out.println("Inside getAllDecks");
        List<TechTag> tags = (List<TechTag>) tr.findAll();
  
        return tags;
    }

}
