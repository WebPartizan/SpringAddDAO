package com.kosmocoourses.java.junior.springhello.service;

import com.kosmocoourses.java.junior.springhello.dao.UserDAO;
import com.kosmocoourses.java.junior.springhello.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    public boolean registerUser(User user){
        if (validation(user)) {
            userDAO.create(user);
            return true;
        } else {
            log.warn("Failed validation for new user: " + user);
            return false;
        }
    }

    public boolean validation(User user){
        // FIXME: add conditions for validation

        return true;
    }

}
