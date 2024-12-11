package com.example.Assignment.controller;

import com.example.Assignment.entity.Student;
import com.example.Assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createstudent")
    public String createstudent(@RequestParam String name, @RequestParam String address){
        return studentService.addstudent(name,address);
    }

    @GetMapping("/getallstudents")
    public ResponseEntity<Iterable<Student>> getallstudents(){
        return ResponseEntity.ok(studentService.getall());
    }
}
