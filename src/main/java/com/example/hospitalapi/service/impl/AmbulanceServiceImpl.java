package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Ambulance;
import com.example.hospitalapi.entity.Hospital;
import com.example.hospitalapi.repository.AmbulanceRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.service.AmbulanceService;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static com.example.hospitalapi.mapper.AmbulanceMapper.AMBULANCE_MAPPER;
import static com.example.hospitalapi.mapper.HospitalMapper.HOSPITAL_MAPPER;

@Service
@RequiredArgsConstructor
public class AmbulanceServiceImpl implements AmbulanceService {
    private final AmbulanceRepository ambulanceRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public List<AmbulanceResource> findAll() {
        return AMBULANCE_MAPPER.toAmbulanceResources(ambulanceRepository.findAll());
    }

    @Override
    public AmbulanceResource save(AmbulanceResource ambulanceResource) {
        Ambulance ambulance = AMBULANCE_MAPPER.fromAmbulanceResource(ambulanceResource);

        if(ambulanceRepository.existsById(ambulance.getId())) {
            throw new RuntimeException("Ambulance with id " + ambulance.getId() + " already exists");
        }
        if(!hospitalRepository.existsById(ambulance.getHospital().getId())) {
            throw new RuntimeException("Hospital with id " + ambulance.getHospital().getId() + " does not exist");
        }
        return AMBULANCE_MAPPER.toAmbulanceResource(ambulanceRepository.save(ambulance));
    }

    @Override
    public AmbulanceResource findById(Long id) {
        return AMBULANCE_MAPPER.toAmbulanceResource(ambulanceRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        ambulanceRepository.deleteById(id);
    }

    @Override
    public List<AmbulanceResource> findByHospitalId(Long id) {
        return AMBULANCE_MAPPER.toAmbulanceResources(ambulanceRepository.findAll().stream()
                .filter(ambulance -> ambulance.getHospital().getId().equals(id))
                .toList());
    }
}
