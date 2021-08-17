package com.revature.overcharge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Set;
import com.revature.overcharge.repositories.SetRepo;

@Service
public class SetServiceImpl implements SetService{

	@Autowired
	SetRepo sr;
	
	@Override
	public Set addSet(Set s) {
		return sr.save(s);
	}

	@Override
	public Set getSet(int id) {
		try {
			return sr.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Set updateSet(Set newSet) {
		return sr.save(newSet);
	}

	@Override
	public boolean deleteSet(int id) {
		try {
			sr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

    @Override
    public List<Set> getSetsByCreatorId(int creatorId) {
        return sr.findByCreatorId(creatorId);
    }
	
}
