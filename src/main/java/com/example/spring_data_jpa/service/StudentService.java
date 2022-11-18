package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.entity.StudentEntity;
import com.example.spring_data_jpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public StudentEntity save(StudentEntity student){
        return studentRepo.save(student);
    }

}
