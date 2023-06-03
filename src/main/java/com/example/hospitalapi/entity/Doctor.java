package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
public class Doctor extends Person{

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Operation> operations;
}
