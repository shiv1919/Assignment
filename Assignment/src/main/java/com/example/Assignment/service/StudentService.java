package com.example.Assignment.service;

import com.example.Assignment.entity.Student;
import com.example.Assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addstudent(@RequestParam String name, @RequestParam String address) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be null or empty.");
            }
            if (address == null || address.trim().isEmpty()) {
                throw new IllegalArgumentException("Student address cannot be null or empty.");
            }
            Student student = new Student();
            student.setName(name);
            student.setAddress(address);
            studentRepository.save(student);
            return "Student created successfully.";
        }
        catch (Exception e) {
            throw new RuntimeException("An error occurred while creating the student: " + e.getMessage(), e);
        }
    }

    public Iterable<Student> getall(){
        try {
            return studentRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all students: " + e.getMessage(), e);
        }
    }

}
