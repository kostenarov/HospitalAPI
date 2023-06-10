package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.controller.resources.PatientResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.repository.BedRepository;
import com.example.hospitalapi.repository.OperationRepository;
import com.example.hospitalapi.repository.PatientRepository;
import com.example.hospitalapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.hospitalapi.mapper.PatientMapper.PATIENT_MAPPER;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final BedRepository bedRepository;
    private final OperationRepository operationRepository;

    @Override
    public List<PatientResource> findAll() {
        return PATIENT_MAPPER.toPatientResources(patientRepository.findAll());
    }

    @Override
    public PatientResource save(PatientResource patientResource) {
        Patient patient = validatePatient(patientResource);
        patient.setOperation(null);
        return PATIENT_MAPPER.toPatientResource(patientRepository.save(patient));
    }

    private Patient validatePatient(PatientResource patientResource) {
        Patient patient = PATIENT_MAPPER.fromPatientResource(patientResource);
        bedRepository.findById(patientResource.getBedId())
                .ifPresentOrElse(
                        patient::setBed,
                        () -> {
                            throw new RuntimeException("Bed not found");
                        }
                );
        patient.getBed().setPatient(patient);
        patient.setAge(patientResource.getAge());
        patient.setFirstName(patientResource.getFirstName());
        patient.setLastName(patientResource.getLastName());
        patient.setAdmissionDate(patientResource.getAdmissionDate());
        return patient;
    }

    @Override
    public PatientResource update(PatientResource patientResource) {
        Patient patient = validatePatient(patientResource);
        patient.setOperation(patientResource.getOperationId() == null ? null : operationRepository.findById(patientResource.getOperationId()).get());
        return PATIENT_MAPPER.toPatientResource(patientRepository.save(patient));
    }

    @Override
    public void addOperation(Long patientId, Operation operation) {
        PatientResource patientResource = findById(patientId).get();
        patientResource.setOperationId(operation.getId());
        update(patientResource);
    }

    @Override
    public Optional<PatientResource> findById(Long id) {
        return patientRepository.findById(id).map(PATIENT_MAPPER::toPatientResource);
    }

    @Override
    public void deleteById(Long id) {
        if(patientRepository.findById(id).get().getOperation() != null)
            operationRepository.deleteById(patientRepository.findById(id).get().getOperation().getId());
        bedRepository.findByPatientId(patientRepository.findById(id).get().getId()).setPatient(null);
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientResource> findByHospitalId(Long id) {
        return PATIENT_MAPPER.toPatientResources(patientRepository.findByBedRoomHospitalId(id));
    }

    @Override
    public List<PatientResource> findByRoomId(Long id) {
        return PATIENT_MAPPER.toPatientResources(patientRepository.findByBedRoomId(id));
    }

    @Override
    public Optional<PatientResource> findByBedId(Long id) {
        Long bedId = bedRepository.findById(id).get().getId();
        PatientResource temp = PATIENT_MAPPER.toPatientResource(patientRepository.findByBedId(bedId));
        return Optional.ofNullable(temp);
    }

    @Override
    public Optional<PatientResource> findByOperationId(Long id) {
        Long operationId = operationRepository.findById(id).get().getId();
        PatientResource temp = PATIENT_MAPPER.toPatientResource(patientRepository.findByOperationId(operationId));
        return Optional.ofNullable(temp);
    }
}
