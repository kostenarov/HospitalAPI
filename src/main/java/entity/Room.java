package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "Hospital")
    private Hospital hospital;

    /*
    @OneToMany
    private ArrayList<Bed> beds;*/
}
