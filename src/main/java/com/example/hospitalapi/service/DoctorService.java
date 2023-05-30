package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<DoctorResource> findAll();

    DoctorResource save(DoctorResource doctor);

    DoctorResource findById(Long id);

    void deleteById(Long id);

    List<DoctorResource> findByHospitalId(Long id);

    DoctorResource findByOperationId(Long id);
}
