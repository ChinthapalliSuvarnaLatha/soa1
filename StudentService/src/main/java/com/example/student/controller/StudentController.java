package com.example.student.controller;

import org.springframework.web.bind.annotation.*;

import com.example.student.model.Student;

@RestController
public class StudentController {

    @PostMapping("/colleges/{collegeId}/students")
    public String addStudent(@PathVariable int collegeId,
                             @RequestBody Student student) {

        return "Student Added Successfully\n"
                + "College ID : " + collegeId
                + "\nStudent ID : " + student.getStudentId()
                + "\nStudent Name : " + student.getStudentName()
                + "\nCourse : " + student.getCourse()
                + "\nMarks : " + student.getMarks();
    }
}
