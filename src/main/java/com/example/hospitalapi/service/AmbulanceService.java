package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.AmbulanceResource;

import java.util.List;

public interface AmbulanceService {
    List<AmbulanceResource> findAll();

    AmbulanceResource save(AmbulanceResource ambulanceResource);

    AmbulanceResource findById(Long id);

    void deleteById(Long id);

    List<AmbulanceResource> findByHospitalId(Long id);
}
