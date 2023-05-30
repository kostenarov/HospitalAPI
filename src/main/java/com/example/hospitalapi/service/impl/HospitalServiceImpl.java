package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.HospitalMapper.HOSPITAL_MAPPER;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository HospitalRepository;
    @Override
    public List<HospitalResource> findAll() {
        return HOSPITAL_MAPPER.toHospitalResources(HospitalRepository.findAll());
    }

    @Override
    public HospitalResource save(HospitalResource hospitalResource) {
        Hospital hospital = HOSPITAL_MAPPER.fromHospitalResource(hospitalResource);
        return HOSPITAL_MAPPER.toHospitalResource(HospitalRepository.save(hospital));
    }

    @Override
    public HospitalResource findById(Long id) {
        return HOSPITAL_MAPPER.toHospitalResource(HospitalRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        HospitalRepository.deleteById(id);
    }
}
