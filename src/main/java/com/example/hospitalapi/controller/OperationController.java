package com.example.hospitalapi.controller;

import com.example.hospitalapi.service.DoctorService;
import com.example.hospitalapi.service.OperationService;
import com.example.hospitalapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;
}
