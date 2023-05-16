package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Patient{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Bed bed;

    int age;
    String FirstName, LastName;

    @OneToOne
    private Operation operation;

    private Date admissionDate;
}
