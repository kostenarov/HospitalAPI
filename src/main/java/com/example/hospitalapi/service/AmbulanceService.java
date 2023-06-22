package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.AmbulanceResource;

import java.util.List;
import java.util.Optional;

public interface AmbulanceService {
    List<AmbulanceResource> findAll();

    AmbulanceResource save(AmbulanceResource ambulanceResource);

    Optional<AmbulanceResource> findById(Long id);

    void deleteById(Long id);

    void deleteAllByHospitalId(Long id);

    List<AmbulanceResource> findByHospitalId(Long id);

    AmbulanceResource update(AmbulanceResource ambulanceResource);
}
