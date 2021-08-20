package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Objective;

public interface ObjectiveService {

    public List<Objective> getAllObjectivesForUser(String id);
    
    

}
