package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Data
@Audited
public class Hospital {

    @Id
    @GeneratedValue
    private Long id;

    private String name, city;

    @OneToMany(mappedBy = "hospital")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital")
    private List<Ambulance> ambulances;

    @OneToMany(mappedBy = "hospital")
    private List<Operation> operations;
}
