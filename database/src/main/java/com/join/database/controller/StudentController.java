package com.join.database.controller;

import com.join.database.entity.Student;
import com.join.database.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/post")
    public Student insertStudent(@RequestBody Student student){
       Student student1= studentService.saved(student);
       student1.setAddress(student.getAddress());
       return student1;
    }

    @PostMapping("/posts")
    public List<Student> insertStudents(@RequestBody List<Student> students){
       List<Student> students1 =new ArrayList<>();
       for(Student student:students){
          Student st= studentService.saved(student);
          st.setAddress(student.getAddress());
          students1.add(st);
       }
       return students1;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.findAllSt();
    }

    @GetMapping("/student/{rollNo}")
    public Student findByRollNoStudent(@PathVariable int rollNo){
        return studentService.findByRollNom(rollNo);
    }

    @GetMapping("/studentName/{name}")
    public Student findByName(@PathVariable String name){
        return studentService.findByStudent (name);
    }

    @GetMapping("/studentGen/{gender}")
    public List<Student> findByGen(@PathVariable String gender){
        return studentService.findByGender(gender);
    }

    @DeleteMapping("/student/{rollNo}")
    public String deleteByRollNo(@PathVariable int rollNo){
        studentService.deleteByRollNo(rollNo);
        return "Student has been removed."+rollNo;
    }

    @PutMapping("/student")
    public Student updateValues(@RequestBody Student student) {
        return studentService.update(student);
    }
    @PatchMapping("/student/{rollNo}")
    public Student updatePartiallyStudent(@PathVariable int rollNo,@RequestBody Student student){
        Student st=studentService.findByRollNom(rollNo);
        if(st!=null){
            if(student!=null){
                st.setName(student.getName());
            }
            return studentService.saved(st);
        }
        else{
            return null;
        }
    }
    @PatchMapping("/students/{rollNo}")
    public Student changeAdd(@PathVariable int rollNo,@RequestBody Student student){
        Student st=studentService.findByRollNom(rollNo);
        st.setAddress(student.getAddress());
        return studentService.saved(st);
    }
    @PatchMapping("/studenta/{rollNo}")
    public Student setEmailAddress(@PathVariable int rollNo,@RequestBody Student student){
        Student st=studentService.findByRollNom(rollNo);
        st.setEmail(student.getEmail());
        return studentService.saved(st);
    }
}