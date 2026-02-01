package com.demo.controller;

import com.demo.entity.SchoolEntity;
import com.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/School")
public class SchoolController {
    @Autowired
    private SchoolService service;

    @PostMapping("/create")
    public ResponseEntity<SchoolEntity> createStudentInfo(@RequestBody SchoolEntity entity){
        SchoolEntity save= service.save(entity);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getStudentInfo/{rollNumber}")
    public ResponseEntity<SchoolEntity> findStudentStatus(@PathVariable Long rollNumber){
        SchoolEntity entity= service.findById(rollNumber);
        if(entity!=null){
            return ResponseEntity.ok(entity);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateStudent/{rollNumber}")
    public ResponseEntity<SchoolEntity> findStudentById(@PathVariable Long rollNumber, @RequestBody SchoolEntity entity){
        SchoolEntity exist= service.findById(rollNumber);
        if(exist != null){
            if(entity.getName() !=null && !entity.getName().isEmpty()){
                exist.setName(entity.getName());
            }
            if(entity.getFatherName()!=null && !entity.getFatherName().isEmpty()){
                exist.setFatherName(entity.getFatherName());
            }
            if(entity.getMotherName()!=null && !entity.getMotherName().isEmpty()){
                exist.setMotherName((entity.getMotherName()));
            }
            SchoolEntity updateStudent= service.save(exist);
            return ResponseEntity.ok(updateStudent);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("studentClass/{rollNumber}")
    public ResponseEntity<SchoolEntity> updateFatherName(@PathVariable Long rollNumber,@RequestBody SchoolEntity entity){
        SchoolEntity findStudent = service.findById(rollNumber);
        if(rollNumber!=null){
            findStudent.setClassName(entity.getClassName());
            findStudent.setMotherName(entity.getSection());
            SchoolEntity update=service.save(findStudent);
            return ResponseEntity.ok(update);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteStudent/{rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long rollNumber) {
        SchoolEntity existingEntity = service.findById(rollNumber);

        if (existingEntity != null) {
            service.deleteById(rollNumber);
            return ResponseEntity.ok("Student with ID " + rollNumber + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
