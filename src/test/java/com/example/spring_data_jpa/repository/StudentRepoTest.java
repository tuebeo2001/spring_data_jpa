package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.GuardianEntity;
import com.example.spring_data_jpa.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent() {
        StudentEntity student = StudentEntity.builder()
                .emailId("student1@gmail.com")
                .firstName("student")
                .lastName("01")
//                .guardianName("tue")
//                .guardianMobile("123")
//                .guardianEmail("tuenk1")
                .build();

        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        GuardianEntity guardianEntity = GuardianEntity.builder()
                .name("tue")
                .mobile("123")
                .email("tuenk1")
                .build();

        StudentEntity student = StudentEntity.builder()
                .firstName("Tue")
                .lastName("Nguyen")
                .emailId("tuenkhe150066")
                .guardianEntity(guardianEntity)
                .build();

        studentRepo.save(student);
    }

    @Test
    public void printAllStudent() {
        List<StudentEntity> studentEntityList = studentRepo.findAll();
        System.out.println("studentList" + studentEntityList);
    }

    @Test
    public void findStudentByFirstName() {
        List<StudentEntity> studentEntityList = studentRepo.findByFirstName("tue");
        System.out.println("List = " + studentEntityList);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<StudentEntity> studentEntityList = studentRepo.findByFirstNameContaining("t");
        System.out.println("List = " + studentEntityList);
    }

    @Test
    public void getStudentByFirstName() {
        List<StudentEntity> studentEntityList = studentRepo.getStudentByFirstNameSQL("tue");
        System.out.println("List = " + studentEntityList);
    }

    @Test
    public void getStudentByFirstNameParamSQL() {
        List<StudentEntity> studentEntityList = studentRepo.getStudentByFirstNameParamSQL("tue");
        System.out.println("List = " + studentEntityList);
    }

    @Test
    public void getStudentByEmailAddress() {
        StudentEntity student = studentRepo.getStudentByEmailAddressSQL("tuenkhe150066");
        System.out.println("List = " + student);
    }
}