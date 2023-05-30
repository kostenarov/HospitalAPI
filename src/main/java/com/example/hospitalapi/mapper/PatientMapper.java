package com.example.hospitalapi.mapper;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.controller.resources.PatientResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PatientMapper {
    public PatientMapper PATIENT_MAPPER = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "bed.id", target = "bedId")
    @Mapping(source = "operation.id", target = "operationId")
    PatientResource toPatientResource(Patient patient);

    @Mapping(source = "bedId", target = "bed.id")
    @Mapping(source = "operationId", target = "operation.id")
    Patient fromPatientResource(PatientResource patientResource);

    List<PatientResource> toPatientResources(List<Patient> all);

    List<Patient> fromPatientResources(List<PatientResource> all);
}
