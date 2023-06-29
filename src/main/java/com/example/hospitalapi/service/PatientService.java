package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.PatientResource;
import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Operation;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResource> findAll();

    PatientResource save(PatientResource patient);

    Optional<PatientResource> findById(Long id);

    void deleteById(Long id);

    List<PatientResource> findByHospitalId(Long id);

    Optional<PatientResource> findByBedId(Long id);

    Optional<PatientResource> findByOperationId(Long id);

    PatientResource update(PatientResource patientResource);

    void addOperation(Long patientId, Operation operation);

    Object findAllAudits(Long id);

    RoomResource movePatientToBed(Long patientId, Long bedId);
}
