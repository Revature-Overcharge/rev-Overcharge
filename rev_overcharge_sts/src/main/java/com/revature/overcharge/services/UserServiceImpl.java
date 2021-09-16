package com.revature.overcharge.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.exception.BadParameterException;
import com.revature.overcharge.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepo ur;

    @Autowired
    ObjectiveService os;

    @Override
    public User addUser(User u) {
        if (ur.existsById(u.getId())) {
            log.warn("User id is invalid for add");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return ur.save(u);
        }
    }

    @Override
    public User getUser(int id) {
        if (ur.existsById(id)) {
            return ur.findById(id).get();
        } else {
            log.warn("User id is not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean deleteUser(int id) {
        if (ur.existsById(id)) {
            ur.deleteById(id);
            return true;
        } else {
            log.warn("User id is invalid for delete");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User login(String username, String password) throws BadParameterException {
        log.info(username + " " + password);
        if (ur.existsByUsernameAndPassword(username, password)) {
            User user = ur.findByUsername(username);
            os.loginObj(user);
            user.setLastLogin(new Date().getTime());
            user = ur.save(user);
            return user;
        } else {
            log.warn("Incorrect credentials provided");
            throw new BadParameterException("Incorrect credentials provided");
        }
    }

}
