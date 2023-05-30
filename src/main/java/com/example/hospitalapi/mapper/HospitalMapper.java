package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {AmbulanceMapper.class, RoomMapper.class, BedMapper.class, DoctorMapper.class})
public interface HospitalMapper {
    public HospitalMapper HOSPITAL_MAPPER = Mappers.getMapper(HospitalMapper.class);

    HospitalResource toHospitalResource(Hospital hospital);

    Hospital fromHospitalResource(HospitalResource hospitalResource);

    List<HospitalResource> toHospitalResources(List<Hospital> hospital);

    List<Hospital> fromHospitalResources(List<HospitalResource> hospitalResource);
}
