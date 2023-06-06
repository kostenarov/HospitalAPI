package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.repository.DoctorRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.repository.OperationRepository;
import com.example.hospitalapi.repository.PatientRepository;
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
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<OperationResource> findAll() {
        return OPERATION_MAPPER.toOperationResources(operationRepository.findAll());
    }

    @Override
    public OperationResource save(OperationResource operationResource) {
        Operation operation = OPERATION_MAPPER.fromOperationResource(operationResource);
        doctorRepository.findById(operationResource.getDoctorId())
                .ifPresentOrElse(
                        operation::setDoctor,
                        () -> {
                            throw new RuntimeException("Doctor not found");
                        }
                );
        hospitalRepository.findById(operationResource.getHospitalId())
                .ifPresentOrElse(operation::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital not found");
                        }
                );
        patientRepository.findById(operationResource.getPatientId())
                .ifPresentOrElse(operation::setPatient,
                        () -> {
                            throw new RuntimeException("Patient not found");
                        }
                );
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
        return OPERATION_MAPPER.toOperationResources(operationRepository.findByHospitalId(id));
    }

    @Override
    public List<OperationResource> findByDoctorId(Long id) {
        return OPERATION_MAPPER.toOperationResources(operationRepository.findByDoctorId(id));
    }

    @Override
    public OperationResource findByPatientId(Long id) {
        return OPERATION_MAPPER.toOperationResource(operationRepository.findByPatientId(id));
    }

    @Override
    public List<OperationResource> findByDate(Date date) {
        return OPERATION_MAPPER.toOperationResources(operationRepository.findByOperationDate(date));
    }

    @Override
    public OperationResource update(OperationResource operationResource) {
        Operation operation = OPERATION_MAPPER.fromOperationResource(operationResource);
        doctorRepository.findById(operationResource.getDoctorId())
                .ifPresentOrElse(
                        operation::setDoctor,
                        () -> {
                            throw new RuntimeException("Doctor not found");
                        }
                );
        hospitalRepository.findById(operationResource.getHospitalId())
                .ifPresentOrElse(operation::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital not found");
                        }
                );
        patientRepository.findById(operationResource.getPatientId())
                .ifPresentOrElse(operation::setPatient,
                        () -> {
                            throw new RuntimeException("Patient not found");
                        }
                );
        if(operationResource.getDate() != null)
            operation.setOperationDate(operationResource.getDate());
        return OPERATION_MAPPER.toOperationResource(operationRepository.save(operation));
    }
}
