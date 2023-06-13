package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;


import java.util.List;

@Entity
@Data
@Audited
public class Doctor extends Person{

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Operation> operations;
}
