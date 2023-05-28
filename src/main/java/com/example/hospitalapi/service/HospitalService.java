package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> findAll();

    Hospital save(Hospital hospital);

    Hospital findById(Long id);

    void deleteById(Long id);
}
