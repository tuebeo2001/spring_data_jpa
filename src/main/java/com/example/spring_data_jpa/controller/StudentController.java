package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.StudentEntity;
import com.example.spring_data_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public StudentEntity save(@RequestBody StudentEntity student){
        return studentService.save(student);
    }
}
