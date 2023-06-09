package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OperationMapper.class)
public interface DoctorMapper {
    DoctorMapper DOCTOR_MAPPER = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "hospital.id", target = "hospitalId")
    DoctorResource toDoctorResource(Doctor doctor);

    @Mapping(source = "hospitalId", target = "hospital.id")
    Doctor fromDoctorResource(DoctorResource doctorResource);

    List<DoctorResource> toDoctorResources(List<Doctor> doctor);

    List<Doctor> fromDoctorResources(List<DoctorResource> doctorResource);
}
