package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.NotAudited;


@Entity
@Data
public class Ambulance {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotAudited
    private Hospital hospital;
}
