package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Audited
public class Hospital {

    @Id
    @GeneratedValue
    private Long id;

    private String name, city;

    @OneToMany(mappedBy = "hospital")
    @NotAudited
    private List<Room> rooms;

    @OneToMany(mappedBy = "hospital")
    @NotAudited
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital")
    @NotAudited
    private List<Ambulance> ambulances;

    @OneToMany(mappedBy = "hospital")
    @NotAudited
    private List<Operation> operations;

    @CreatedDate
    private Date createdDate = new Timestamp(System.currentTimeMillis());

    @PrePersist
    @PreUpdate
    @PreRemove
    public void preAction() {
        createdDate = new Timestamp(System.currentTimeMillis());
    }
}
