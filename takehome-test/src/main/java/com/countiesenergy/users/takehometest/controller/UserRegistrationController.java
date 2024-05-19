package com.countiesenergy.users.takehometest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.countiesenergy.users.takehometest.model.User;
import com.countiesenergy.users.takehometest.service.UserRegistrationService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The contoller class which exposes the APIs for User registration and search
 * by LastName and ID
 * 
 * @GetById : To retrive user from the Id
 *          API Documentation /swagger-ui/index.html#/user-registration-controller/getUserById
 * @GetByLastName : To retrive user by user's last name,
 *          API Documentation /swagger-ui/index.html#/user-registration-controller/getByLastName
 * @addUser : To registor a new user,
 *          API Documentation /swagger-ui/index.html#/user-registration-controller/addUser
 */

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userInfo) {
        this.userRegistrationService = userInfo;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<User>> getByLastName(@RequestParam(name = "lastName") String lastName) {
        try {
            List<User> users = userRegistrationService.getUserByLastName(lastName);
            return (null != users && users.size() > 0) ? new ResponseEntity<List<User>>(users, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (UnsupportedOperationException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {

        try {
            User userInfo = userRegistrationService.getUserById(id);
            return userInfo != null ? new ResponseEntity<User>(userInfo, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addUser(@RequestBody User newUser) {
        try {
            userRegistrationService.saveUser(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UnsupportedOperationException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
