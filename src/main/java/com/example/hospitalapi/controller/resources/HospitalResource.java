package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HospitalResource {
    private Long id;
    private String name, city;
    private Date createdDate;
    private List<RoomResource> rooms;
    private List<DoctorResource> doctors;
    private List<AmbulanceResource> ambulances;
    private List<OperationResource> operations;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
