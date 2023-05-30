package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    public DoctorMapper DOCTOR_MAPPER = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "hospital.id", target = "hospitalId")
    DoctorResource toResource(Doctor doctor);

    @Mapping(source = "hospitalId", target = "hospital.id")
    Doctor toEntity(DoctorResource doctorResource);
}
