package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Hospital;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository HospitalRepository;
    @Override
    public List<Hospital> findAll() {
        return HospitalRepository.findAll();
    }

    @Override
    public Hospital save(Hospital hospital) {
        return HospitalRepository.save(hospital);
    }

    @Override
    public Hospital findById(Long id) {
        return HospitalRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        HospitalRepository.deleteById(id);
    }
}
