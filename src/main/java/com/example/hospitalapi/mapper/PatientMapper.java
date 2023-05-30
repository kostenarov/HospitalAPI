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

    @Mapping(source = "patient.id", target = "patientId")
    PatientResource toPatientResource(Patient patient);

    @Mapping(source = "patientId", target = "patient.id")
    Patient fromPatientResource(PatientResource patientResource);

    @Mapping(source = "patient.id", target = "patientId")
    List<PatientResource> toPatientResources(List<Patient> all);

    @Mapping(source = "patientId", target = "patient.id")
    List<Patient> fromPatientResources(List<PatientResource> all);
}
