package com.kata.bddtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void getStudentDetailsFromDB_whenNamePrefixWithAIsPassed_shouldReturnStudentDetailsWithFirstNameStartingWithA() {
        String namePrefix = "a";

        List<Student> actualStudentData = studentDatabase.getStudentDetailsFromDB(namePrefix);

        assertAll("actualStudentData",
                () -> assertEquals("abhishek", actualStudentData.get(0).getFirstName()),
                () -> assertEquals("rajput", actualStudentData.get(0).getLastName())
        );
    }

    @Test
    void getStudentDetailsFromDB_whenNamePrefixWithNIsPassed_shouldReturnStudentDetailsWithFirstNameStartingWithN() {
        String namePrefix = "n";

        List<Student> actualStudentData = studentDatabase.getStudentDetailsFromDB(namePrefix);

        assertAll("actualStudentData",
                () -> assertEquals("novita", actualStudentData.get(0).getFirstName())
        );
    }
}