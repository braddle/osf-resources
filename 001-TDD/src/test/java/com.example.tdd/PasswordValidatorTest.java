package com.example.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    @Test
    @DisplayName("Password should not be empty")
    void passwordIsNotEmpty() {
        assertFalse(PasswordValidator.isValid(""));
    }
}
