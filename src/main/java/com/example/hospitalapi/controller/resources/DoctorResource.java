package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.util.List;

@Data
public class DoctorResource {
    private Long id;
    private String name;
    private String surname;
    private Long hospitalId;
    private List<OperationResource> operations;
}
