package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HospitalMapper {
    public HospitalMapper HOSPITAL_MAPPER = Mappers.getMapper(HospitalMapper.class);

    @Mapping(source = "hospital.id", target = "hospitalId")
    HospitalResource toResource(Hospital hospital);

    @Mapping(source = "hospitalId", target = "hospital.id")
    Hospital toEntity(HospitalResource hospitalResource);
}
