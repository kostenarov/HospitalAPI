package com.example.hospitalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@Audited
public class Bed {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    @OneToOne
    @NotAudited
    private Patient patient;

    @CreatedDate
    private Date modifiedDate;

    private Date ValidFrom;

    @PrePersist
    @PreUpdate
    @PreRemove
    public void preAction() {
        modifiedDate = new Date();
    }
}
