package com.join.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",initialValue = 1,allocationSize = 1)
    private int rollNo;
    private String id;
    private String name;
    private int age;
    private Date dateOfBirth;
    private String gender;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
