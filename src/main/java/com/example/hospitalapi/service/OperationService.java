package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.OperationResource;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface OperationService {
    List<OperationResource> findAll();

    OperationResource save(OperationResource operation);

    Optional<OperationResource> findById(Long id);

    void deleteById(Long id);

    List<OperationResource> findByHospitalId(Long id);

    List<OperationResource> findByDoctorId(Long id);

    Optional<OperationResource> findByPatientId(Long id);

    List<OperationResource> findByDate(Date date);

    OperationResource update(OperationResource operationResource);
}
