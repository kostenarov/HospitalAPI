package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.entity.Ambulance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AmbulanceMapper {
    public AmbulanceMapper AMBULANCE_MAPPER = Mappers.getMapper(AmbulanceMapper.class);

    @Mapping(source = "ambulance.id", target = "id")
    AmbulanceResource toAmbulanceResource(Ambulance ambulance);

    @Mapping(source = "id", target = "ambulance.id")
    Ambulance fromAmbulanceResource(AmbulanceResource ambulanceResource);

    @Mapping(source = "ambulance.id", target = "id")
    List<AmbulanceResource> toAmbulanceResources(List<Ambulance> ambulanceList);
}
