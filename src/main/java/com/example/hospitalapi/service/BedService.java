package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Bed;

import java.util.List;

public interface BedService {
    List<BedResource> findAll();

    Bed save(Bed bed);

    BedResource findById(Long id);

    void deleteById(Long id);

    List<BedResource> findByRoomId(Long id);

    List<BedResource> findByPatientId(Long id);

    List<BedResource> findByHospitalId(Long id);
}
