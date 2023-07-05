package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.FlightResource;
import com.example.hospitalapi.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FlightMapper {
    FlightMapper FLIGHT_MAPPER = Mappers.getMapper(FlightMapper.class);

    public FlightResource toFlightResource(Flight flight);

    public Flight fromFlightResource(FlightResource flightResource);

    public List<FlightResource> toFlightResources(List<Flight> flightList);

    public List<Flight> fromFlightResources(List<FlightResource> flightResourceList);
}
