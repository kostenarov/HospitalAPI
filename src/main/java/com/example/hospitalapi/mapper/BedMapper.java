package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Bed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = RoomMapper.class)
public interface BedMapper {

    public BedMapper BED_MAPPER = Mappers.getMapper(BedMapper.class);

    @Mapping(source = "room.id", target = "roomId")
    BedResource toBedResource(Bed bed);

    @Mapping(source = "roomId", target = "room.id")
    Bed fromBedResource(BedResource bedResource);

    @Mapping(source = "operation.id", target = "operationId")
    List<BedResource> toBedResources(List<Bed> bedList);

    @Mapping(source = "operationId", target = "operation.id")
    List<Bed> fromBedResources(List<BedResource> bedResourceList);
}
