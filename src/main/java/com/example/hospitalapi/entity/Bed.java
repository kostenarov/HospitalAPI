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
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne
    private Patient patient;
}
