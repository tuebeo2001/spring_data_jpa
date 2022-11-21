package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.CourseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    CourseRepo courseRepo;

    @Test
    public void printCourses() {
        List<CourseEntity> courses =
                courseRepo.findAll();
        System.out.println(courses);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 2);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);
        Pageable thirdPageWithThreeRecords = PageRequest.of(2, 2);
        Pageable fourthPageWithThreeRecords = PageRequest.of(3, 2);

        List<CourseEntity> course1 =
                courseRepo.findAll(firstPageWithThreeRecords).getContent();
        List<CourseEntity> course2 =
                courseRepo.findAll(secondPageWithThreeRecords).getContent();
        List<CourseEntity> course3 =
                courseRepo.findAll(thirdPageWithThreeRecords).getContent();
        List<CourseEntity> course4 =
                courseRepo.findAll(fourthPageWithThreeRecords).getContent();
        long totalElements =
                courseRepo.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages =
                courseRepo.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(course4);
        System.out.println(totalPages);
        System.out.println(totalElements);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 4, Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(0, 4, Sort.by("credit").ascending());

        List<CourseEntity> courseEntities = courseRepo.findAll(sortByCredit).getContent();

        System.out.println(courseEntities);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPage = PageRequest.of(0, 4, Sort.by("title"));
        List<CourseEntity> courses =
                courseRepo.findByTitleContaining("Cour",firstPage).getContent();

        System.out.println(courses);
    }

}