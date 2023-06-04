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

    @Override
    public List<BedResource> findAll() {
        return BED_MAPPER.toBedResources(bedRepository.findAll());
    }

    @Override
    public BedResource save(BedResource bedResource) {
        Bed bed = BED_MAPPER.fromBedResource(bedResource);
        bed.setPatient(null);
        return BED_MAPPER.toBedResource(bedRepository.save(bed));
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
        return BED_MAPPER.toBedResources(bedRepository.findByRoomId(id));
    }

    @Override
    public BedResource findByPatientId(Long id) {
        return BED_MAPPER.toBedResource(bedRepository.findByPatientId(id));
    }

    @Override
    public List<BedResource> findByHospitalId(Long id) {
        return BED_MAPPER.toBedResources(bedRepository.findByRoomHospitalId(id));
    }

    @Override
    public BedResource update(BedResource bedResource) {
        if(bedResource.getId() == null) {
            return save(bedResource);
        } else {
            Bed bed = BED_MAPPER.fromBedResource(bedResource);
            return BED_MAPPER.toBedResource(bedRepository.save(bed));
        }
    }
}
