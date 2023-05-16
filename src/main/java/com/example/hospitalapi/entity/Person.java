package com.example.hospitalapi.entity;

import lombok.Data;

@Data
public abstract class Person {
    int age;
    String FirstName, LastName;
}
