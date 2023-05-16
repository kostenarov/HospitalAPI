package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends Person{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Bed bed;

    @OneToOne
    private Operation operation;

    private Date admissionDate;
}
