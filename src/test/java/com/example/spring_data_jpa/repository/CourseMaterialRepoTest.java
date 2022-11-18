package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.CourseEntity;
import com.example.spring_data_jpa.entity.CourseMaterialEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo repo;

    @Test
    public void saveCourseMaterial(){
        CourseEntity course = CourseEntity.builder()
                .title("Course 1")
                .credit(6)
                .build();

        CourseMaterialEntity courseMaterial = CourseMaterialEntity.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repo.save(courseMaterial);
    }
    @Test
    public void printCourseMaterial(){
        List<CourseMaterialEntity> list = repo.findAll();
        System.out.println("courseMaterials = "+ list);
    }
}