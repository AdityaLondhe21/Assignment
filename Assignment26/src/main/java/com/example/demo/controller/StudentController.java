package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path="/students",method= {RequestMethod.POST,RequestMethod.PUT})
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student saved successfully in both databases";
    }
}
