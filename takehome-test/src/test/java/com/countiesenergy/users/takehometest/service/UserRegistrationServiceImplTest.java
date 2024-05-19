package com.countiesenergy.users.takehometest.service;

import com.countiesenergy.users.takehometest.model.User;
import com.countiesenergy.users.takehometest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserRegistrationServiceImplTest {

    @InjectMocks
    UserRegistrationServiceImpl userRegistrationService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return users when valid last name is provided")
    public void shouldReturnUsersWhenValidLastNameIsProvided() {
        User user = new User();
        user.setLastName("Eroshan");
        List<User> users = Arrays.asList(user);
        when(userRepository.findByLastName("Eroshan")).thenReturn(users);

        List<User> response = userRegistrationService.getUserByLastName("Eroshan");

        assertEquals(users, response);
    }

    @Test
    @DisplayName("Should throw exception when invalid last name is provided")
    public void shouldThrowExceptionWhenInvalidLastNameIsProvided() {
        assertThrows(UnsupportedOperationException.class, () -> userRegistrationService.getUserByLastName(""));
    }

    @Test
    @DisplayName("Should save user when valid user is provided")
    public void shouldSaveUserWhenValidUserIsProvided() {
        User newUser = new User();
        newUser.setFirstName("Eroshan");
        newUser.setLastName("Jayawardhane");
        newUser.setEmail("ero.ja@gmail.com");

        userRegistrationService.saveUser(newUser);
    }

    @Test
    @DisplayName("Should throw exception when invalid user is provided")
    public void shouldThrowExceptionWhenInvalidUserIsProvided() {
        User newUser = new User();
        newUser.setFirstName("");
        newUser.setLastName("");

        assertThrows(UnsupportedOperationException.class, () -> userRegistrationService.saveUser(newUser));
    }

}
