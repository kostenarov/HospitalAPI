package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
public class Hospital {

    @Id
    @GeneratedValue
    private Long id;

    private String Name, City;

    @OneToMany(mappedBy = "hospital")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital")
    private List<Ambulance> ambulances;

    @OneToMany(mappedBy = "hospital")
    private List<Operation> operations;
}
