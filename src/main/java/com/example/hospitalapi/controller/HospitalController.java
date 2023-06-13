package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HospitalResource hospitalResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/hospital/{id}")
                .buildAndExpand(hospitalService.save(hospitalResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody HospitalResource hospitalResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/hospital/{id}")
                .buildAndExpand(hospitalService.update(hospitalResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        hospitalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(hospitalService.findAll());
    }

    @GetMapping("/audits/{id}")
    public ResponseEntity<?> findAllAudits(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.findAllAudits(id));
    }

    @GetMapping("/date")
    public ResponseEntity<?> getUpUntilDate(@RequestParam String date) {
        return ResponseEntity.ok(hospitalService.getUpUntilDate(date));
    }
}
