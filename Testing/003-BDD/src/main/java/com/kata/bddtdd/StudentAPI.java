package com.kata.bddtdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentAPI {

    private StudentDatabase studentDatabase;

    public StudentAPI(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    @GetMapping("/search/{namePrefix}")
    public List<Student> getStudentDetails(@PathVariable String namePrefix) {
        return this.studentDatabase.getStudentDetailsFromDB(namePrefix);
    }
}
