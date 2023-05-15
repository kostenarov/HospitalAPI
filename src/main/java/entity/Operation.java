package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;

    @OneToOne(mappedBy = "Patient")
    private Patient patient;

    @OneToOne(mappedBy = "Doctor")
    private Doctor doctor;

    private Date operationDate;
}
