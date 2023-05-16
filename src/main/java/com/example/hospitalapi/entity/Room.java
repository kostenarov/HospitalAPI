package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToMany
    @JoinColumn(name = "bed_id")
    private List<Bed> beds;
}
