package com.example.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeapYearCalculatorTest {

    private LeapYearCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new LeapYearCalculator();
    }

    @Test
    void YearsNotDivisibleBy4AreNot() {
        assertFalse(calc.isLeapYear(2022));
        assertFalse(calc.isLeapYear(2023));
    }

    @Test
    void yearsDivisibleBy400AreLeapYears() {
        assertTrue(calc.isLeapYear(400));
        assertTrue(calc.isLeapYear(800));
    }

    @Test
    void yearsDivisibleBy100ByNot400AreNotLeapYears() {
        assertFalse(calc.isLeapYear(100));
        assertFalse(calc.isLeapYear(500));
    }

    @Test
    void YearsDivisibleBy4ButNot100AreLeapYears() {
        assertTrue(calc.isLeapYear(4));
        assertTrue(calc.isLeapYear(2136));
    }
}
