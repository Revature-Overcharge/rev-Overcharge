package com.revature.overcharge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepo ur;

    @Override
    public User getUserByUname(String username) {
        try {
            return ur.getUserByUsername(username);
        } catch (Exception e) {
            log.warn(e);
            return new User();
        }
    }

    @Override
    public User addUser(User p) {
        return ur.save(p);
    }

    @Override
    public User getUser(int id) {
        try {
            return ur.findById(id).get();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public User updateUser(User change) {
        return ur.save(change);
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            ur.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

}
