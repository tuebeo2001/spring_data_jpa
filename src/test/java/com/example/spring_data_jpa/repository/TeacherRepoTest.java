package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.CourseEntity;
import com.example.spring_data_jpa.entity.TeacherEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher(){
        CourseEntity course = CourseEntity.builder()
                .title("IMP301999")
                .credit(10)
                .build();

        CourseEntity course1 = CourseEntity.builder()
                .title("DPL9999")
                .credit(10)
                .build();

        TeacherEntity teacher = TeacherEntity.builder()
                .firstName("tue99")
                .lastName("nguyen99")
                .courses(List.of(course, course1))
                .build();

        teacherRepo.save(teacher);
    }
}