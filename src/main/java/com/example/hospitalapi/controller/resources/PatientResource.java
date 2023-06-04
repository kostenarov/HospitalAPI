package com.example.hospitalapi.controller.resources;

import com.example.hospitalapi.entity.Person;
import lombok.Data;

import java.sql.Date;

@Data
public class PatientResource {
    private Long id;
    private String firstName;
    private String lastName;
    private Long bedId;
    private Long operationId;
    private Long hospitalId;
    private Date admissionDate;

    public Long getOperationId() {
        return operationId;
    }

    public Long getBedId() {
        return bedId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

}
