package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Audited
public class Patient extends Person {

    @OneToOne(mappedBy = "patient")
    private Bed bed;

    @OneToOne(optional = true, mappedBy = "patient")
    @NotAudited
    private Operation operation;

    @CreationTimestamp
    private Date admissionDate;

    @LastModifiedDate
    private Date modifiedDate = new Timestamp(System.currentTimeMillis());

    @PrePersist
    @PreUpdate
    @PreRemove
    public void preAction() {
        modifiedDate = new Timestamp(System.currentTimeMillis());
    }
}
