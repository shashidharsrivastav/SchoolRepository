package com.join.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_seq",initialValue = 10,allocationSize = 1)
    private int id;
    private String fathersName;
    private String mothersName;
    private String mobileNumber;
    private String village;
    private String post;
    private String district;
    private int zipcode;

//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Student student;
}