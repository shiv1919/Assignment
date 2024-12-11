package com.example.Assignment.controller;

import com.example.Assignment.entity.Subject;
import com.example.Assignment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/createsubject")
    public String createsubject(@RequestParam String name){
        return subjectService.addsubject(name);
    }

    @GetMapping("/getallsubjects")
    public ResponseEntity<Iterable<Subject>> getallsubjects(){
        return ResponseEntity.ok(subjectService.getall());
    }

}
