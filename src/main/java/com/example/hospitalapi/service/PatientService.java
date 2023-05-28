package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();

    Patient save(Patient patient);

    Patient findById(Long id);

    void deleteById(Long id);

    List<Patient> findByHospitalId(Long id);

    List<Patient> findByRoomId(Long id);

    List<Patient> findByBedId(Long id);

    List<Patient> findByOperationId(Long id);
}
