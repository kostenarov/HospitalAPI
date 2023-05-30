package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<HospitalResource> findAll();

    HospitalResource save(HospitalResource hospital);

    HospitalResource findById(Long id);

    void deleteById(Long id);
}
