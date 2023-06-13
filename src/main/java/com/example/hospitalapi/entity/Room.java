package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Data
@Audited
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "room")
    private List<Bed> beds;
}
