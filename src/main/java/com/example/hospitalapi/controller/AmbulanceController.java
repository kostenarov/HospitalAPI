package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.service.AmbulanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ambulance")
@RequiredArgsConstructor
public class AmbulanceController {
    private final AmbulanceService ambulanceService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ambulanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ambulanceService.findById(id));
    }

    @GetMapping("/hospital/{id}")
    public List<ResponseEntity<?>> findByHospitalId(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/save")
    public Long save(@RequestBody AmbulanceResource ambulanceResource) {
        return ambulanceResource.getHospitalId();
    }
}
