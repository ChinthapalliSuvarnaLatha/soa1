package com.example.studentservice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/students")
    public String getStudents() {
        return "Student Details: arna, Puji, Deekshu";
    }
}