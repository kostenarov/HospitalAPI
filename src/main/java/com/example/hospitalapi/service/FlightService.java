package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.FlightResource;

import java.util.List;

public interface FlightService {
    public List<FlightResource> getFlightBySourceAndDestination(String source, String destination);
}
