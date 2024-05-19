package com.countiesenergy.users.takehometest.controller;

import com.countiesenergy.users.takehometest.model.User;
import com.countiesenergy.users.takehometest.service.UserRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class UserRegistrationControllerTest {

    @InjectMocks
    UserRegistrationController userRegistrationController;

    @Mock
    UserRegistrationService userRegistrationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return users when users exist by last name")
    public void shouldReturnUsersWhenUsersExistByLastName() {
        User user = new User();
        user.setLastName("Eroshan");
        List<User> users = Arrays.asList(user);
        when(userRegistrationService.getUserByLastName("Eroshan")).thenReturn(users);

        ResponseEntity<List<User>> response = userRegistrationController.getByLastName("Eroshan");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    @DisplayName("Should return internal server error when exception is thrown by last name")
    public void shouldReturnInternalServerErrorWhenExceptionIsThrownByLastName() {
        when(userRegistrationService.getUserByLastName("Eroshan")).thenThrow(new RuntimeException());

        ResponseEntity<List<User>> response = userRegistrationController.getByLastName("Eroshan");

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return bad request error when exception is thrown by last name")
    public void shouldReturnBadRequestErrorWhenExceptionIsThrownByLastName() {
        when(userRegistrationService.getUserByLastName("Eroshan")).thenThrow(new UnsupportedOperationException());

        ResponseEntity<List<User>> response = userRegistrationController.getByLastName("Eroshan");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return user when user exists by id")
    public void shouldReturnUserWhenUserExistsById() {
        User user = new User();
        when(userRegistrationService.getUserById(1)).thenReturn(user);

        ResponseEntity<User> response = userRegistrationController.getUserById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    @DisplayName("Should return not found when user does not exist by id")
    public void shouldReturnNotFoundWhenUserDoesNotExistById() {
        when(userRegistrationService.getUserById(1)).thenReturn(null);

        ResponseEntity<User> response = userRegistrationController.getUserById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return internal server error when exception is thrown by id")
    public void shouldReturnInternalServerErrorWhenExceptionIsThrownById() {
        when(userRegistrationService.getUserById(1)).thenThrow(new RuntimeException());

        ResponseEntity<User> response = userRegistrationController.getUserById(1);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return OK when user is added successfully")
    public void shouldReturnOkWhenUserIsAddedSuccessfully() {
        User newUser = new User();
        doNothing().when(userRegistrationService).saveUser(newUser);

        ResponseEntity<HttpStatus> response = userRegistrationController.addUser(newUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return internal server error when exception is thrown while adding user")
    public void shouldReturnInternalServerErrorWhenExceptionIsThrownWhileAddingUser() {
        User newUser = new User();
        doThrow(new RuntimeException()).when(userRegistrationService).saveUser(newUser);

        ResponseEntity<HttpStatus> response = userRegistrationController.addUser(newUser);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    @DisplayName("Should return bad request error when exception is thrown while adding user")
    public void shouldReturnBadRequestErrorWhenExceptionIsThrownWhileAddingUser() {
        User newUser = new User();
        doThrow(new UnsupportedOperationException()).when(userRegistrationService).saveUser(newUser);

        ResponseEntity<HttpStatus> response = userRegistrationController.addUser(newUser);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}