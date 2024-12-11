package com.example.Assignment.service;

import com.example.Assignment.entity.Subject;
import com.example.Assignment.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public String addsubject(@RequestParam String name){
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Subject name cannot be null or empty.");
            }
            Subject subject=new Subject();
            subject.setName(name);
            subjectRepository.save(subject);
            return "Subject created successfully.";
        }
        catch (Exception e) {
            throw new RuntimeException("An error occurred while creating the subject: " + e.getMessage(), e);
        }
    }

    public Iterable<Subject> getall(){
        try {
            return subjectRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all subjects: " + e.getMessage(), e);
        }
    }
}
