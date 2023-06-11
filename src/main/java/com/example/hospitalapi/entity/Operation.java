package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToOne(mappedBy = "operation")
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private Date operationDate;
}
