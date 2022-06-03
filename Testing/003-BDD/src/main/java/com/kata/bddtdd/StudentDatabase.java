package com.kata.bddtdd;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDatabase {

    public List<Student> getStudentDetailsFromDB(String namePrefix) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student("abhishek", "rajput");
        Student student1 = new Student("novita", "s");
        Student student2 = new Student("shin", "chan");
        Student student3 = new Student("ash", "ketchum");
        Student student4 = new Student("john", "cena");
        Student student5 = new Student("roger", "federer");
        Student student6 = new Student("david", "beckham");
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);

        return studentList.stream().filter(
                studentDetails -> studentDetails.getFirstName().startsWith(namePrefix)
        ).collect(Collectors.toList());
    }
}
