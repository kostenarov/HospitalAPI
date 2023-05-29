package com.example.hospitalapi.controller;

import com.example.hospitalapi.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bed")
@RequiredArgsConstructor
public class BedController {
    private final BedService bedService;
}
