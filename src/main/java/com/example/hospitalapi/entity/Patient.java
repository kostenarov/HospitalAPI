package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Patient extends Person{

    @OneToOne
    private Bed bed;

    @OneToOne
    private Operation operation;

    private Date admissionDate;
}
