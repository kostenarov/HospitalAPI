package com.example.hospitalapi.controller.resources;

import lombok.Data;

@Data
public abstract class PersonResource {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
