package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ambulance {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
