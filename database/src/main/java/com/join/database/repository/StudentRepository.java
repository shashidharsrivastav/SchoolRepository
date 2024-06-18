package com.join.database.repository;

import com.join.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByRollNo(int rollNo);

    List<Student> findByGender(String gender);

    Student findByName(String name);

}
