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

    @Mapping(source = "hospital.id", target = "hospitalId")
    HospitalResource toHospitalResource(Hospital hospital);

    @Mapping(source = "hospitalId", target = "hospital.id")
    Hospital fromHospitalResource(HospitalResource hospitalResource);

    @Mapping(source = "hospital.id", target = "hospitalId")
    List<HospitalResource> toHospitalResources(List<Hospital> hospital);

    @Mapping(source = "hospitalId", target = "hospital.id")
    List<Hospital> fromHospitalResources(List<HospitalResource> hospitalResource);
}
