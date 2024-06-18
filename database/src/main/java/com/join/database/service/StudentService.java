package com.join.database.service;

import com.join.database.entity.Address;
import com.join.database.entity.Student;
import com.join.database.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void deleteByRollNo(int rollNo){
        studentRepository.deleteById((long) rollNo);
    }

    public Student update(Student student) {
        Student exist = studentRepository.findByRollNo(student.getRollNo());
        exist.setName(student.getName());
        exist.setGender(student.getGender());
        exist.setId(student.getId());
        exist.setAge(student.getAge());
        exist.setAddress(student.getAddress());
        exist.setEmail(student.getEmail());
        exist.setDateOfBirth(student.getDateOfBirth());
        return studentRepository.save(exist);
    }

    public Student saved(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> savedAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public List<Student> findAllSt() {
        return studentRepository.findAll();
    }

    public Student findByRollNom(int rollNo) {
       return studentRepository.findByRollNo(rollNo);
    }

    public Student findByStudent(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> findByGender(String gender) {
        return studentRepository.findByGender(gender);
    }
}
