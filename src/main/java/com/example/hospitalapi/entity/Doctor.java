package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Doctor{
    @Id
    @GeneratedValue
    private Long id;

    int age;
    String FirstName, LastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Operation> operations;
}
