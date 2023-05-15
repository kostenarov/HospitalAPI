package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bed {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    @OneToOne(mappedBy = "Patient")
    private Patient patient;
}
