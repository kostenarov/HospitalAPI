package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "room")
    private List<Bed> beds;
}
