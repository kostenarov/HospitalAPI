package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.HospitalResource;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    List<HospitalResource> findAll();

    HospitalResource save(HospitalResource hospital);

    Optional<HospitalResource> findById(Long id);

    void deleteById(Long id);

    HospitalResource update(HospitalResource hospitalResource);

    Object findAllAudits(Long id);

    Object getUpUntilDate(String date);
}
