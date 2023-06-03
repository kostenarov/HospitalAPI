package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.hospitalapi.service.OperationService;

import java.sql.Date;
import java.util.List;

import static com.example.hospitalapi.mapper.OperationMapper.OPERATION_MAPPER;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService{
    private final OperationRepository operationRepository;

    @Override
    public List<OperationResource> findAll() {
        return OPERATION_MAPPER.toOperationResources(operationRepository.findAll());
    }

    @Override
    public OperationResource save(OperationResource operationResource) {
        Operation operation = OPERATION_MAPPER.fromOperationResource(operationResource);
        return OPERATION_MAPPER.toOperationResource(operationRepository.save(operation));
    }

    @Override
    public OperationResource findById(Long id) {
        return OPERATION_MAPPER.toOperationResource(operationRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        operationRepository.deleteById(id);
    }

    @Override
    public List<OperationResource> findByHospitalId(Long id) {
        return findAll().stream().filter(operationResource -> operationResource.getHospitalId().equals(id)).toList();
    }

    @Override
    public List<OperationResource> findByDoctorId(Long id) {
        return findAll().stream().filter(operationResource -> operationResource.getDoctorId().equals(id)).toList();
    }

    @Override
    public OperationResource findByPatientId(Long id) {
        return findAll().stream().filter(operationResource -> operationResource.getPatientId().equals(id)).toList().get(0);
    }

    @Override
    public List<OperationResource> findByDate(Date date) {
        return findAll().stream().filter(operationResource -> operationResource.getDate().equals(date)).toList();
    }

    @Override
    public OperationResource update(OperationResource operationResource) {
        Operation operation = OPERATION_MAPPER.fromOperationResource(operationResource);
        return OPERATION_MAPPER.toOperationResource(operationRepository.save(operation));
    }
}
