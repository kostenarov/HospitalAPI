package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.NotAudited;

import java.sql.Date;


@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotAudited
    private Hospital hospital;

    @OneToOne(optional = false)
    @NotAudited
    private Patient patient;

    @ManyToOne
    @NotAudited
    private Doctor doctor;

    private Date operationDate;
}
