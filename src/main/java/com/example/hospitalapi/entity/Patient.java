package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Entity
@Data
public class Patient extends Person {

    @OneToOne(mappedBy = "patient")
    private Bed bed;

    @OneToOne(optional = true, mappedBy = "patient")
    private Operation operation;

    private Date admissionDate;
}
