package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Ambulance;

import java.util.List;

public interface AmbulanceService {
    List<Ambulance> findAll();

    Ambulance save(Ambulance ambulance);

    Ambulance findById(Long id);

    void deleteById(Long id);

    List<Ambulance> findByHospitalId(Long id);
}
