package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.Date;

@Entity
@Data
@Audited
public class Patient extends Person {

    @OneToOne(mappedBy = "patient")
    private Bed bed;

    @OneToOne(optional = true, mappedBy = "patient")
    @NotAudited
    private Operation operation;

    private Date admissionDate = new Date();
}
