package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.exception.BadParameterException;

public interface UserService {

    public User addUser(User p);

    public User getUser(int id);

    public List<User> getAllUsers();

    public User updateUser(User change);

    public boolean deleteUser(int id);

    public User login(User u);

}
