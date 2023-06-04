package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.service.DoctorService;
import com.example.hospitalapi.service.OperationService;
import com.example.hospitalapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1/operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OperationResource operationResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/operation/{id}")
                .buildAndExpand(operationService.save(operationResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody OperationResource operationResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/operation/{id}")
                .buildAndExpand(operationService.update(operationResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        operationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> findByPatientId(@PathVariable Long id) {
        return ResponseEntity.ok(operationService.findByPatientId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(operationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(operationService.findById(id));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> findByDoctorId(@PathVariable Long id) {
        return ResponseEntity.ok(operationService.findByDoctorId(id));
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(operationService.findByHospitalId(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<?> findByDate(@PathVariable String date) {
        Date date1 = Date.valueOf(date);
        return ResponseEntity.ok(operationService.findByDate(date1));
    }
}
