package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.PatientResource;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PatientResource patientResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/patient/{id}")
                .buildAndExpand(patientService.save(patientResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PatientResource patientResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/patient/{id}")
                .buildAndExpand(patientService.update(patientResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/bed/{id}")
    public ResponseEntity<?> findByBedId(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findByBedId(id));
    }

    @GetMapping("/operation/{id}")
    public ResponseEntity<?> findByOperationId(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findByOperationId(id));
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findByHospitalId(id));
    }

    @PutMapping("/addOperation/{id}")
    public ResponseEntity<?> addOperation(@PathVariable Long id, @RequestBody Operation operation) {
        patientService.addOperation(id, operation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/audits/{id}")
    public ResponseEntity<?> findAllAudits(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findAllAudits(id));
    }
}
