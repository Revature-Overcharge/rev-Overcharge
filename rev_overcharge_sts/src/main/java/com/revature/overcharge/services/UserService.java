package com.revature.overcharge.services;

import com.revature.overcharge.beans.User;

public interface UserService {

    public User addUser(User u);

    public User getUser(int id);

    public User updateUser(User newUser);

    public boolean deleteUser(int id);

}
