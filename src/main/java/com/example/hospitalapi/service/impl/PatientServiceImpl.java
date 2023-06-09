package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.PatientResource;
import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.repository.BedRepository;
import com.example.hospitalapi.repository.OperationRepository;
import com.example.hospitalapi.repository.PatientRepository;
import com.example.hospitalapi.repository.RoomRepository;
import com.example.hospitalapi.service.PatientService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.hospitalapi.mapper.PatientMapper.PATIENT_MAPPER;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final BedRepository bedRepository;
    private final OperationRepository operationRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final RoomRepository roomRepository;


    @Override
    public List<PatientResource> findAll() {
        return PATIENT_MAPPER.toPatientResources(patientRepository.findAll());
    }

    @Override
    public PatientResource save(PatientResource patientResource) {
        Patient patient = validatePatient(patientResource);
        patient.setOperation(null);

        if(bedRepository.existsById(patientResource.getBedId())) {
            patient.setBed(bedRepository.findById(patientResource.getBedId()).get());
        }
        patient.setModifiedDate(patientResource.getModifiedDate());
        patient.setAdmissionDate(patientResource.getAdmissionDate());
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
        return patient;
    }

    @Override
    public PatientResource update(PatientResource patientResource) {
        Patient patient = validatePatient(patientResource);
        patient.setOperation(patientResource.getOperationId() == null ? null : operationRepository.findById(patientResource.getOperationId()).get());
        patient.setModifiedDate(patientResource.getModifiedDate());
        patient.setAdmissionDate(patientRepository.findById(patientResource.getId()).get().getAdmissionDate());
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
    public RoomResource movePatientToBed(Long patientId, Long bedId) {
        PatientResource patientResource = findById(patientId).get();
        patientResource.setBedId(bedId);
        update(patientResource);
        return roomRepository.findByBedId(patientRepository.getById(patientId).getBed().getId());
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

    @Override
    public Object findAllAudits(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Patient.class, id);
        List<PatientResource> result = new ArrayList<>();
        for(Number revision : revisions) {
            Patient patient = auditReader.find(Patient.class, id, revision);
            result.add(PATIENT_MAPPER.toPatientResource(patient));
        }
        return result;
    }
}
