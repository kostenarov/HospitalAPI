package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Bed;
import com.example.hospitalapi.repository.BedRepository;
import com.example.hospitalapi.service.BedService;
import com.example.hospitalapi.service.PatientService;
import com.example.hospitalapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.BedMapper.BED_MAPPER;

@Service
@RequiredArgsConstructor
public class BedServiceImpl implements BedService {
    private final BedRepository bedRepository;

    private final PatientService patientService;

    private final RoomService roomService;

    @Override
    public List<BedResource> findAll() {
        return BED_MAPPER.toResources(bedRepository.findAll());
    }

    @Override
    public Bed save(Bed bed) {
        return bedRepository.save(bed);
    }

    @Override
    public BedResource findById(Long id) {
        return BED_MAPPER.toBedResource(bedRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        bedRepository.deleteById(id);
    }

    @Override
    public List<BedResource> findByRoomId(Long id) {
        return BED_MAPPER.toResources(bedRepository.findAll().stream()
                .filter(bed -> bed.getRoom().getId().equals(id))
                .toList());
    }

    /*@Override
    public List<BedResource> findByPatientId(Long id) {
        return BED_MAPPER.toResources(bedRepository.findAll().stream()
                .filter(bed -> bed.getPatient().getId().equals(id))
                .toList());
    }*/

    @Override
    public List<BedResource> findByHospitalId(Long id) {
        return BED_MAPPER.toResources(bedRepository.findAll().stream()
                .filter(bed -> bed.getRoom().getHospital().getId().equals(id))
                .toList());
    }
}
