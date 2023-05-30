package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    protected Long id;
    protected int age;
    protected String FirstName, LastName;

    public Long getId() {
        return id;
    }
}
