package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.DoctorResource;

import java.util.List;

public interface DoctorService {
    List<DoctorResource> findAll();

    DoctorResource save(DoctorResource doctor);

    DoctorResource findById(Long id);

    void deleteById(Long id);

    List<DoctorResource> findByHospitalId(Long id);

    DoctorResource update(DoctorResource doctorResource);
}
