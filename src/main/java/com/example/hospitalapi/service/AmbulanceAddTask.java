package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.AmbulanceResource;
import com.example.hospitalapi.repository.AmbulanceRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.example.hospitalapi.mapper.AmbulanceMapper.AMBULANCE_MAPPER;

@Component
public class AmbulanceAddTask {
    private final HospitalRepository hospitalRepository;
    private final AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceAddTask(HospitalRepository hospitalRepository, AmbulanceRepository ambulanceRepository) {
        this.hospitalRepository = hospitalRepository;
        this.ambulanceRepository = ambulanceRepository;
    }

    @Scheduled(cron = "0 0 0 1 */3 *")
    public void addAmbulance() {
        hospitalRepository.findAll().forEach(hospital -> {
            if(hospital.getAmbulances().size() < 3) {
                AmbulanceResource ambulanceResource = new AmbulanceResource();
                ambulanceResource.setHospitalId(hospital.getId());
                ambulanceResource.setId(hospital.getAmbulances().size() + 1L);
                ambulanceRepository.save(AMBULANCE_MAPPER.fromAmbulanceResource(ambulanceResource));
            }
        });
    }
}
