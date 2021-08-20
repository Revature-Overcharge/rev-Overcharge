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
    public User addUser(User u) {
        if (ur.existsById(u.getId())) {
            log.warn("User id is invalid for add");
            return null;
        } else {
            return ur.save(u);
        }
    }

    @Override
    public User getUser(int id) {
        try {
            return ur.findById(id).get();
        } catch (Exception e) {
            log.warn(e);
            return null;
        }

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public User updateUser(User change) {
        if (ur.existsById(change.getId())) {
            return ur.save(change);
        } else {
            log.warn("User id is invalid for update");
            return null;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        if (ur.existsById(id)) {
            ur.deleteById(id);
            return true;
        } else {
            log.warn("Deck id is invalid for delete");
            return false;
        }
    }

}
