package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
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
