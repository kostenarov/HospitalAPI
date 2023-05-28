package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Bed;
import com.example.hospitalapi.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BedServiceImpl implements BedService {
    private final BedService BedService;

    @Override
    public List<Bed> findAll() {
        return BedService.findAll();
    }

    @Override
    public Bed save(Bed bed) {
        return BedService.save(bed);
    }

    @Override
    public Bed findById(Long id) {
        return BedService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        BedService.deleteById(id);
    }

    @Override
    public List<Bed> findByRoomId(Long id) {
        return BedService.findByRoomId(id);
    }

    @Override
    public List<Bed> findByPatientId(Long id) {
        return BedService.findByPatientId(id);
    }

    @Override
    public List<Bed> findByHospitalId(Long id) {
        return BedService.findByHospitalId(id);
    }
}
