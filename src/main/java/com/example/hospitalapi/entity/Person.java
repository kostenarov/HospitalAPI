package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    private Long id;
    int age;
    String FirstName, LastName;
}
