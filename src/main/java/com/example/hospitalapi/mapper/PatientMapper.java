package com.example.hospitalapi.mapper;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.controller.resources.PatientResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    public PatientMapper PATIENT_MAPPER = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "patient.id", target = "patientId")
    PatientResource toResource(Patient patient);

    @Mapping(source = "patientId", target = "patient.id")
    Patient toEntity(PatientResource patientResource);
}
