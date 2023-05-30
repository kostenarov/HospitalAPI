package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.controller.resources.PatientResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResource> findAll();

    PatientResource save(PatientResource patient);

    PatientResource findById(Long id);

    void deleteById(Long id);

    List<PatientResource> findByHospitalId(Long id);

    List<PatientResource> findByRoomId(Long id);

    PatientResource findByBedId(Long id);

    PatientResource findByOperationId(Long id);

    PatientResource update(PatientResource patientResource);

    void addOperation(Long patientId, Operation operation);
}
