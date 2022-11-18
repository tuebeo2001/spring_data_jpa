package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {
}
