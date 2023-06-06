package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.sql.Date;

@Data
public class PatientResource {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Long bedId;
    private Long operationId;
    private Date admissionDate;

    public Long getOperationId() {
        return operationId;
    }

    public Long getBedId() {
        return bedId;
    }
}
