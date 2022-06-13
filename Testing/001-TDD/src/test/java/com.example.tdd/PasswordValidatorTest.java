package com.example.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    @Test
    @DisplayName("Password should not be empty")
    void passwordIsNotEmpty() {
        assertFalse(PasswordValidator.isNotEmpty(""));
    }

    @Test
    @DisplayName("Password should not be empty")
    void passwordIsNotEmptyReturnsTrueIfNotEmpty() {
        assertTrue(PasswordValidator.isNotEmpty("test"));
    }

    @Test
    void passwordIsLessThanEightCharactersInvalid(){
        assertFalse(PasswordValidator.isOverEightChars(""));
    }

    @Test
    void passwordIsMoreThanEightCharactersIsValid(){
        assertTrue(PasswordValidator.isOverEightChars("sssssssssss"));
    }

    @Test
    void passwordContainingAtLeastOneUppercaseLetterIsValid(){
        assertTrue(PasswordValidator.containsUpperCase("Password123"));
    }

    @Test
    void passwordContainingNoUppercaseLetterIsInvalid(){
        assertFalse(PasswordValidator.containsUpperCase("password123"));
    }

    @Test
    void passwordContainingAtLeastOneNumberIsValid(){
        assertTrue(PasswordValidator.containsNumber("Password123"));
    }

    @Test
    void passwordContainingNoOneNumberIsInvalid(){
        assertFalse(PasswordValidator.containsNumber("Passwordddd"));
    }

    @Test
    void passwordContainingAtLeastOneSpecialCharacterIsValid(){
        assertTrue(PasswordValidator.containsSpecialChar("*"));
    }

    @Test
    void passwordContainingNoSpecialCharacterIsInvalid(){
        assertFalse(PasswordValidator.containsSpecialChar("i"));
    }

    @Test
    void passwordMeetingAllConditionsIsValid(){
        assertTrue(PasswordValidator.isValid("P@ssword123"));
    }

}
