package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.util.List;

@Data
public class DoctorResource {
    private Long id;
    private String firstName;
    private String lastName;
    private Long hospitalId;
    private int age;
    private List<OperationResource> operations;

    public List<OperationResource> getOperations() {
        return operations;
    }
}
