package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByFirstName(String firstName);

    List<StudentEntity> findByFirstNameContaining(String name);

    List<StudentEntity> findByLastNameAndFirstName(String lastName, String firstName);

    List<StudentEntity> findByGuardianEntityName(String name);

    //Native
    @Query(value = "select * from tbl_student where first_name =?1", nativeQuery = true)
    List<StudentEntity> getStudentByFirstNameSQL(String firstName);

    //JPQL
    @Query(value = "select s from StudentEntity s where s.emailId = ?1")
    StudentEntity getStudentByEmailAddressSQL(String email);

    //Native Named Param
    @Query(value = "select * from tbl_student where first_name = :firstName", nativeQuery = true)
    List<StudentEntity> getStudentByFirstNameParamSQL(
            @Param("firstName") String firstName
    );

    // Tìm hiểu về @Modifying @Transactional



}
