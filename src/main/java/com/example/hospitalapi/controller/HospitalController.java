package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
