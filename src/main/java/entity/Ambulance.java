package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ambulance {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Hospital hospital;
}
