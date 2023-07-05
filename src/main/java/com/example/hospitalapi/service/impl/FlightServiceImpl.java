package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.FlightResource;
import com.example.hospitalapi.repository.FlightRepository;
import com.example.hospitalapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.FlightMapper.FLIGHT_MAPPER;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public List<FlightResource> getFlightBySourceAndDestination(String source, String destination) {
        List<FlightResource> flights = FLIGHT_MAPPER.toFlightResources(flightRepository.findByDepartureAndArrival(source, destination));
        return flights;
    }
}
