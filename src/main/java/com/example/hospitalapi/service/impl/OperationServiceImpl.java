package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.hospitalapi.service.OperationService;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService{
    private final OperationService OperationService;

    @Override
    public List<Operation> findAll() {
        return OperationService.findAll();
    }

    @Override
    public Operation save(Operation operation) {
        return OperationService.save(operation);
    }

    @Override
    public Operation findById(Long id) {
        return OperationService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        OperationService.deleteById(id);
    }

    @Override
    public List<Operation> findByHospitalId(Long id) {
        return null;
    }

    @Override
    public List<Operation> findByDoctorId(Long id) {
        return null;
    }

    @Override
    public Operation findByPatientId(Long id) {
        return null;
    }

    @Override
    public List<Operation> findByDate(Date date) {
        return null;
    }
}
