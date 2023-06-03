package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Person;

import java.util.List;

public interface BedService {
    List<BedResource> findAll();

    BedResource save(BedResource bedResource);

    BedResource findById(Long id);

    void deleteById(Long id);

    List<BedResource> findByRoomId(Long id);

    BedResource findByPatientId(Long id);

    List<BedResource> findByHospitalId(Long id);

    BedResource update(BedResource bedResource);
}
