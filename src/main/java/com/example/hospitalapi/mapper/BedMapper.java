package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Bed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BedMapper {

    public BedMapper BED_MAPPER = Mappers.getMapper(BedMapper.class);

    @Mapping(source = "room.id", target = "roomId")
    BedResource toBedResource(Bed bed);

    @Mapping(source = "roomId", target = "room.id")
    Bed fromBedResource(BedResource bedResource);

    @Mapping(source = "patient.id", target = "patientId")
    BedResource toBedResourceWithPatient(Bed bed);

    @Mapping(source = "patientId", target = "patient.id")
    Bed fromBedWithPatient(BedResource bedResource);

    @Mapping(source = "operation.id", target = "operationId")
    List<BedResource> toResources(List<Bed> bedList);
}
