package com.revature.overcharge.services;

import java.util.Date;
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
    
    @Autowired
    ObjectiveService os;

//    @Override
//    public User getUserByUname(String username) {
//        if (ur.existsByUsername(username)) {
//            User user = ur.getUserByUsername(username);
//            user.setLastLogin(new Date().getTime());
//            return user;
//        } else {
//            log.warn("No user exists by that username");
//            return new User();
//        }
//    }

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

    @Override
    public User login(User u) {
        if (ur.existsByUsernameAndPassword(u.getUsername(), u.getPassword())) {
            User user = ur.findByUsername(u.getUsername());
            user.setLastLogin(new Date().getTime());
            ur.save(user);
            os.loginObj();
            return user;
        } else {
            log.warn("Username and password are incorrect");
            return null;
        }
    }

}
