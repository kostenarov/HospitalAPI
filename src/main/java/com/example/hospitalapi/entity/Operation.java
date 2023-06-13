package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.sql.Date;

@Entity
@Data
@Audited
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private Date operationDate;
}
