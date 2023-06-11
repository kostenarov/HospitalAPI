package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bed {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    @OneToOne(optional = true, mappedBy = "bed")
    private Patient patient;
}
