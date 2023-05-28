package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Operation;

import java.sql.Date;
import java.util.List;

public interface OperationService {
    List<Operation> findAll();

    Operation save(Operation operation);

    Operation findById(Long id);

    void deleteById(Long id);

    List<Operation> findByHospitalId(Long id);

    List<Operation> findByDoctorId(Long id);

    Operation findByPatientId(Long id);

    List<Operation> findByDate(Date date);
}
