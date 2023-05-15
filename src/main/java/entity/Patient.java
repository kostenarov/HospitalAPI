package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends Person{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Bed bed;

    private Date admissionDate;
}
