package com.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity {
    @Id
    private Long rollNumber;

    private String name;
    private String fatherName;
    private String motherName;
    private Integer className;
    private String section;
}
