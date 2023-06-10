package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.DoctorResource;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<DoctorResource> findAll();

    DoctorResource save(DoctorResource doctor);

    Optional<DoctorResource> findById(Long id);

    void deleteById(Long id);

    List<DoctorResource> findByHospitalId(Long id);

    DoctorResource update(DoctorResource doctorResource);
}
