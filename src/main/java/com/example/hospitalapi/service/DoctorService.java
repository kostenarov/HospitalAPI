package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();

    Doctor save(Doctor doctor);

    Doctor findById(Long id);

    void deleteById(Long id);

    List<Doctor> findByHospitalId(Long id);

    List<Doctor> findByOperationId(Long id);
}
