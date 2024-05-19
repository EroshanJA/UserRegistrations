package com.countiesenergy.users.takehometest.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.countiesenergy.users.takehometest.model.User;

/**
 * User registration and search service interface that provides the funtional
 * interface for the controller
 */

@Repository
public interface UserRegistrationService {

    List<User> getUserByLastName(String name);

    void saveUser(User newUser);

    User getUserById(int id);
}
