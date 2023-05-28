package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Bed;

import java.util.List;

public interface BedService {
    List<Bed> findAll();

    Bed save(Bed bed);

    Bed findById(Long id);

    void deleteById(Long id);

    List<Bed> findByRoomId(Long id);

    List<Bed> findByPatientId(Long id);

    List<Bed> findByHospitalId(Long id);
}
