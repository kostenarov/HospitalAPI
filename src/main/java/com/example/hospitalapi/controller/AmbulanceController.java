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

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AmbulanceResource ambulanceResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/ambulance/{id}")
                .buildAndExpand(ambulanceService.save(ambulanceResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AmbulanceResource ambulanceResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/ambulance/{id}")
                .buildAndExpand(ambulanceService.update(ambulanceResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ambulanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(ambulanceService.findByHospitalId(id));
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ambulanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ambulanceService.findById(id));
    }

}
