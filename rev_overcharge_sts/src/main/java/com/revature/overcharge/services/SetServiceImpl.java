package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.Set;
import com.revature.overcharge.repositories.SetRepo;

@Service
public class SetServiceImpl implements SetService {

    private static final Logger log = Logger.getLogger(SetServiceImpl.class);

    @Autowired
    SetRepo sr;

    @Override
    public Set addSet(Set s) {
        if (sr.existsById(s.getId())) {
            log.warn("set id is invalid for add");
            return null;
        } else {
            return sr.save(s);
        }
    }

    @Override
    public Set getSet(int id) {
        try {
            return sr.findById(id).get();
        } catch (Exception e) {
            log.warn(e);
            return null;
        }
    }

    @Override
    public Set updateSet(Set newSet) {
        if (sr.existsById(newSet.getId())) {
            return sr.save(newSet);
        } else {
            log.warn("set id is invalid for update");
            return null;
        }
    }

    @Override
    public boolean deleteSet(int id) {
        try {
            sr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(e);
            return false;
        }
    }

    @Override
    public List<Set> getSetsByCreatorId(int creatorId) {
        return sr.findByCreatorId(creatorId);
    }

}
