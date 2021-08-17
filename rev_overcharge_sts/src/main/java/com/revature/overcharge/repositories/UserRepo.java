package com.revature.overcharge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.overcharge.beans.User;

public interface UserRepo extends CrudRepository<User, Integer>{
    
}