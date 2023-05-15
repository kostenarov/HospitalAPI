package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Hospital {

    @Id
    @GeneratedValue
    private Long id;

    private String Name, City;

    /*Ne znam dali e taka ili ne
    @OneToMany
    private ArrayList<Room> rooms;

    @OneToMany
    private ArrayList<Doctor> doctors;

    @OneToMany
    private ArrayList<Ambulance> ambulances;

    @OneToMany
    private ArrayList<Operation> operations;*/
}
