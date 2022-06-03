package com.kata.bddtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentAPITest {

    private StudentAPI studentAPI;
    private StudentDatabase mockStudentDatabase;

    @BeforeEach
    void setUp() {
        mockStudentDatabase = mock(StudentDatabase.class);
        studentAPI = new StudentAPI(mockStudentDatabase);
    }

    @Test
    @DisplayName("Get Student details for a valid name prefix")
    void getStudentDetails_whenNamePrefixIsPassed_shouldReturnStudentDetails() {
        //Arrange
        String namePrefix = "a";
        Student mockData = new Student("abhishek", "rajput");
        when(mockStudentDatabase.getStudentDetailsFromDB(namePrefix)).thenReturn(asList(mockData));

        //Action
        List<Student> actualStudentData = studentAPI.getStudentDetails(namePrefix);

        //Assertion
        assertAll("actualStudentData",
                () -> assertEquals("abhishek", actualStudentData.get(0).getFirstName()),
                () -> assertEquals("rajput", actualStudentData.get(0).getLastName())
        );
    }
}