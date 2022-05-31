package com.example.demo;

import com.example.demo.fizzbuzz.FizzBuzz;
import com.example.demo.fizzbuzz.FizzBuzzService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzServiceTest {

    @Test
    @DisplayName("Blank input should be invalid")
    void testErrorStateBlankInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals(true, fizzBuzz.getErrorState(),
                "A blank input should result in an error state");
    }

    @Test
    @DisplayName("Blank input should be invalid")
    void testErrorMessageBlankInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals(true, fizzBuzz.getErrorState(),
                "A String input should result in an error state");
    }

    @Test
    @DisplayName("String input should be invalid")
    void testErrorStateStringInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("Test");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals(true, fizzBuzz.getErrorState(),
                "A String input should result in an error state");
    }

    @Test
    @DisplayName("String input error message")
    void testErrorMessageStringInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("Test");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals("Input must be an integer", fizzBuzz.getError(),
                "A correct error message should be displayed");
    }

    @Test
    @DisplayName("String input should be valid")
    void testErrorStateIntegerInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("2");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals(false, fizzBuzz.getErrorState(),
                "A integer input should result in non error state");
    }

    @Test
    @DisplayName("String input should be valid")
    void testValidatedIntegerInput() {
        FizzBuzz fizzBuzz = new FizzBuzz("2");
        FizzBuzzService.validate(fizzBuzz);
        assertEquals(2, fizzBuzz.getValidatedInput(),
                "A integer input should result in an validated input");
    }

    @Test
    @DisplayName("A non-multiple of 3 or 5 should return the number")
    void testNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz("1");
        fizzBuzz.setErrorState(false);
        fizzBuzz.setValidatedInput(Integer.parseInt(fizzBuzz.getInput()));
        FizzBuzzService.calculate(fizzBuzz);
        assertEquals("1", fizzBuzz.getResult(),
                "1 should return 1.");
    }

    @Test
    @DisplayName("A multiple of 3 should return fizz")
    void testMult3() {
        FizzBuzz fizzBuzz = new FizzBuzz("3");
        fizzBuzz.setErrorState(false);
        fizzBuzz.setValidatedInput(Integer.parseInt(fizzBuzz.getInput()));
        FizzBuzzService.calculate(fizzBuzz);
        assertEquals("fizz", fizzBuzz.getResult(),
                "3 should return fizz.");
    }

    @Test
    @DisplayName("A multiple of 5 should return buzz")
    void testMult5() {
        FizzBuzz fizzBuzz = new FizzBuzz("5");
        fizzBuzz.setErrorState(false);
        fizzBuzz.setValidatedInput(Integer.parseInt(fizzBuzz.getInput()));
        FizzBuzzService.calculate(fizzBuzz);
        assertEquals("buzz", fizzBuzz.getResult(),
                "5 should return buzz.");
    }

    @Test
    @DisplayName("A multiple of 3 should return fizz")
    void testProcessNonMult() {
        FizzBuzz fizzBuzz = new FizzBuzz("4");
        FizzBuzzService.process(fizzBuzz);
        assertEquals("4", fizzBuzz.getResult(),
                "4 should return 4.");
    }

    @Test
    @DisplayName("A multiple of 3 should return fizz")
    void testProcessMult3() {
        FizzBuzz fizzBuzz = new FizzBuzz("3");
        FizzBuzzService.process(fizzBuzz);
        assertEquals("fizz", fizzBuzz.getResult(),
                "3 should return fizz.");
    }

    @Test
    @DisplayName("A multiple of 5 should return buzz")
    void testProcessMult5() {
        FizzBuzz fizzBuzz = new FizzBuzz("5");
        FizzBuzzService.process(fizzBuzz);
        assertEquals("buzz", fizzBuzz.getResult(),
                "5 should return buzz.");
    }
}
