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
    private Date modifiedDate;

    public Long getOperationId() {
        return operationId;
    }

    public Long getBedId() {
        return bedId;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
}
