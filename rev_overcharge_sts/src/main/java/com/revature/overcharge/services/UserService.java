package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.User;

public interface UserService {

//    public User getUserByUname(String username);

    public User addUser(User p);

    public User getUser(int id);

    public List<User> getAllUsers();

    public User updateUser(User change);

    public boolean deleteUser(int id);

    public User login(User u);

}
