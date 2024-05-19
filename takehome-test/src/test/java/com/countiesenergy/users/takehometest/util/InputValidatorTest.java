package com.countiesenergy.users.takehometest.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
public class InputValidatorTest {
 
    @Test
    @DisplayName("Should return true when valid email is provided")
    public void shouldReturnTrueWhenValidEmailIsProvided() {
        assertTrue(InputValidator.validateUserEmail("test@example.com"));
    }
 
    @Test
    @DisplayName("Should return false when invalid email is provided")
    public void shouldReturnFalseWhenInvalidEmailIsProvided() {
        assertFalse(InputValidator.validateUserEmail("test@example"));
    }
 
    @Test
    @DisplayName("Should return false when null email is provided")
    public void shouldReturnFalseWhenNullEmailIsProvided() {
        assertFalse(InputValidator.validateUserEmail(null));
    }
 
    @Test
    @DisplayName("Should return true when valid name is provided")
    public void shouldReturnTrueWhenValidNameIsProvided() {
        assertTrue(InputValidator.validateUserName("Eroshan"));
    }
 
    @Test
    @DisplayName("Should return false when invalid name is provided")
    public void shouldReturnFalseWhenInvalidNameIsProvided() {
        assertFalse(InputValidator.validateUserName("Eroshan123"));
    }
 
    @Test
    @DisplayName("Should return false when null name is provided")
    public void shouldReturnFalseWhenNullNameIsProvided() {
        assertFalse(InputValidator.validateUserName(null));
    }
}