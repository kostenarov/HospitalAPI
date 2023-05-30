package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.entity.Ambulance;

import java.util.List;

public interface AmbulanceService {
    List<AmbulanceResource> findAll();

    Ambulance save(AmbulanceResource ambulanceResource);

    AmbulanceResource findById(Long id);

    void deleteById(Long id);

    List<AmbulanceResource> findByHospitalId(Long id);
}
