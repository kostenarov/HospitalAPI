package com.example.hospitalapi.controller;

import com.example.hospitalapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    @GetMapping("/flight")
    public ResponseEntity<?> getFlight() {
        return ResponseEntity.ok(flightService.getFlightBySourceAndDestination("Delhi", "Mumbai"));
    }
}
