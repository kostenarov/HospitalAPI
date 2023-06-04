package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/bed")
@RequiredArgsConstructor
public class BedController {
    private final BedService bedService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BedResource bedResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/bed/{id}")
                .buildAndExpand(bedService.save(bedResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BedResource bedResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/bed/{id}")
                .buildAndExpand(bedService.update(bedResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bedService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bedService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.findById(id));
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<?> findByRoomId(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.findByRoomId(id));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> findByPatientId(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.findByPatientId(id));
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.findByHospitalId(id));
    }
}
