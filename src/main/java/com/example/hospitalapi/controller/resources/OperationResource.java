package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.sql.Date;

@Data
public class OperationResource {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private Date date;
    private Long hospitalId;
}
