package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.List;

@Entity
@Data
@Audited
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotAudited
    private Hospital hospital;

    @OneToMany(mappedBy = "room")
    @NotAudited
    private List<Bed> beds;
}
