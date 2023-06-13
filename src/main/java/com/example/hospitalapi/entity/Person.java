package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@MappedSuperclass
@Audited
public abstract class Person {
    @Id
    @GeneratedValue
    private Long id;
    private int age;
    private String firstName, lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
