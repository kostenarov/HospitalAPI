package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.entity.Ambulance;
import com.example.hospitalapi.repository.AmbulanceRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.service.AmbulanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.hospitalapi.mapper.AmbulanceMapper.AMBULANCE_MAPPER;

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
        hospitalRepository.findById(ambulance.getHospital().getId())
                .ifPresentOrElse(ambulance::setHospital,
                () -> {
                    throw new RuntimeException("Hospital with id " + ambulance.getHospital().getId() + " does not exist");
                }
        );
        return AMBULANCE_MAPPER.toAmbulanceResource(ambulanceRepository.save(ambulance));
    }

    @Override
    public Optional<AmbulanceResource> findById(Long id) {
        return ambulanceRepository.findById(id).map(AMBULANCE_MAPPER::toAmbulanceResource);
    }

    @Override
    public void deleteById(Long id) {
        ambulanceRepository.deleteById(id);
    }

    @Override
    public void deleteAllByHospitalId(Long id) {
        ambulanceRepository.deleteAllByHospitalId(id);
    }

    @Override
    public List<AmbulanceResource> findByHospitalId(Long id) {
        return AMBULANCE_MAPPER.toAmbulanceResources(ambulanceRepository.findAllByHospitalId(id));
    }

    @Override
    public AmbulanceResource update(AmbulanceResource ambulanceResource) {
        Ambulance ambulance = AMBULANCE_MAPPER.fromAmbulanceResource(ambulanceResource);
        hospitalRepository.findById(ambulance.getHospital().getId())
                .ifPresentOrElse(ambulance::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital with id " + ambulance.getHospital().getId() + " does not exist");
                        }
                );
        if(ambulanceRepository.findById(ambulance.getId()).isEmpty())
            throw new RuntimeException("Ambulance with id " + ambulance.getId() + " does not exist");
        if(ambulance == ambulanceRepository.findById(ambulance.getId()).get())
            throw new RuntimeException("Ambulance with id " + ambulance.getId() + " is the same as the one in the database");
        return AMBULANCE_MAPPER.toAmbulanceResource(ambulanceRepository.save(ambulance));
    }
}
