package com.example.hospitalapi.controller.resources;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@OnDelete(action = OnDeleteAction.CASCADE)
public class HospitalResource {
    private Long id;
    private String name, city;
    private List<RoomResource> rooms;
    private List<DoctorResource> doctors;
    private List<AmbulanceResource> ambulances;
    private List<OperationResource> operations;
}
