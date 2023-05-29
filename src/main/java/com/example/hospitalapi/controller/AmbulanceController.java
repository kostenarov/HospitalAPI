package com.example.hospitalapi.controller;

import com.example.hospitalapi.service.AmbulanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ambulance")
@RequiredArgsConstructor
public class AmbulanceController {
    private final AmbulanceService ambulanceService;
}
