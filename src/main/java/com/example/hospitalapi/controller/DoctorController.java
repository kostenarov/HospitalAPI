package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/hospital/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DoctorResource doctorResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/doctor/{id}")
                .buildAndExpand(doctorService.save(doctorResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DoctorResource doctorResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/doctor/{id}")
                .buildAndExpand(doctorService.update(doctorResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findByHospitalId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }
}
