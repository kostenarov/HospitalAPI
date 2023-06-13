package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Data
@Audited
public class Bed {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    @OneToOne(optional = true)
    private Patient patient;
}
