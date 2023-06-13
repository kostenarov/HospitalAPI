package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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
    @NotAudited
    private Patient patient;
}
