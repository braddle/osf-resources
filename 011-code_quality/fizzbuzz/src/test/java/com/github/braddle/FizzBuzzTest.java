package com.github.braddle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz buzzer;
    @BeforeEach
    void setUp() {
        Rule[] rules = new Rule[1];
        rules[0] = new NoChangeRule();

        buzzer = new FizzBuzz(rules);
    }

    @Test
    void onlyPositiveNumbersAllowed() {
        assertEquals("", buzzer.run(0));
        assertEquals("", buzzer.run(-1));
        assertEquals("", buzzer.run(-3));
        assertEquals("", buzzer.run(-5));
        assertEquals("", buzzer.run(-15));
    }

    @Test
    void returnsNumberWhenNotDivisibleBy3or5() {
        assertEquals("1", buzzer.run(1));
        assertEquals("2", buzzer.run(2));
        assertEquals("4", buzzer.run(4));
        assertEquals("7", buzzer.run(7));
    }
}
