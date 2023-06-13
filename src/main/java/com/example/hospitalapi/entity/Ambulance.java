package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Data
@Audited
public class Ambulance {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;
}
