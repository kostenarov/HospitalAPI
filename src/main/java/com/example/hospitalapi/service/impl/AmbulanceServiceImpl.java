package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Ambulance;
import com.example.hospitalapi.service.AmbulanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmbulanceServiceImpl implements AmbulanceService {
    private final AmbulanceService AmbulanceService;
    @Override
    public List<Ambulance> findAll() {
        return AmbulanceService.findAll();
    }

    @Override
    public Ambulance save(Ambulance ambulance) {
        return AmbulanceService.save(ambulance);
    }

    @Override
    public Ambulance findById(Long id) {
        return AmbulanceService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        AmbulanceService.deleteById(id);
    }

    @Override
    public List<Ambulance> findByHospitalId(Long id) {
        return AmbulanceService.findByHospitalId(id);
    }
}
