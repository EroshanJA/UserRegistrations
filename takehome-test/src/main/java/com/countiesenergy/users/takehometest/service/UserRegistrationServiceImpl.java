package com.countiesenergy.users.takehometest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.countiesenergy.users.takehometest.model.User;
import com.countiesenergy.users.takehometest.repository.UserRepository;
import com.countiesenergy.users.takehometest.util.InputValidator;

/**
 * User registration and search service implementation that provides the
 * funtionality
 * for the controller
 */

@Repository
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserByLastName(String name) {
        if (name != null && InputValidator.validateUserName(name)) {
            return userRepository.findByLastName(name);
        } else {
            throw new UnsupportedOperationException("Invalid Last Name");
        }
    }

    @Override
    public void saveUser(User newUser) {
        if (newUser != null && InputValidator.validateUserName(newUser.getFirstName())
                && InputValidator.validateUserName(newUser.getLastName()) && InputValidator.validateUserEmail(newUser.getEmail())) {
            userRepository.save(newUser);
        } else {
            throw new UnsupportedOperationException("Invalid user data");
        }
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

}
