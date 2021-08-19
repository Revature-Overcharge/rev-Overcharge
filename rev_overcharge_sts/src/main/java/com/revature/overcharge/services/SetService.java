package com.revature.overcharge.services;

import com.revature.overcharge.beans.Set;

public interface SetService {

	public Set addSet(Set s);
	
	public Set getSet(int id);
	
	public Set updateSet(Set newSet);
	
	public boolean deleteSet(int id);
	
}