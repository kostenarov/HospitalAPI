package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.BedResource;
import com.example.hospitalapi.entity.Bed;
import com.example.hospitalapi.repository.BedRepository;
import com.example.hospitalapi.repository.PatientRepository;
import com.example.hospitalapi.repository.RoomRepository;
import com.example.hospitalapi.service.BedService;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.hospitalapi.mapper.BedMapper.BED_MAPPER;

@Service
@RequiredArgsConstructor
public class BedServiceImpl implements BedService {
    private final BedRepository bedRepository;
    private final RoomRepository roomRepository;
    private final PatientRepository patientRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<BedResource> findAll() {
        return BED_MAPPER.toBedResources(bedRepository.findAll());
    }

    @Override
    public BedResource save(BedResource bedResource) {
        Bed bed = BED_MAPPER.fromBedResource(bedResource);
        roomRepository.findById(bedResource.getRoomId())
                .ifPresentOrElse(
                        bed::setRoom,
                        () -> {
                            throw new RuntimeException("Room not found");
                        }
                );
        bed.setPatient(null);
        return BED_MAPPER.toBedResource(bedRepository.save(bed));
    }

    @Override
    public Optional<BedResource> findById(Long id) {
        Date date = new Date();
        if(bedRepository.findById(id).get().getValidFrom().before(date))
            return bedRepository.findById(id).map(BED_MAPPER::toBedResource);
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteByBedId(id);
        bedRepository.deleteById(id);
    }

    @Override
    public List<BedResource> findByRoomId(Long id) {
        List<BedResource> result = new ArrayList<>();
        List<BedResource> beds = BED_MAPPER.toBedResources(bedRepository.findByRoomId(id));
        for(BedResource bed : beds) {
            if(bed.getValidFrom().before(new Date())) {
                result.add(bed);
            }
        }
        return result;
    }

    @Override
    public Optional<BedResource> findByPatientId(Long id) {
        Long patientId = patientRepository.findById(id).get().getId();
        BedResource bedRes = BED_MAPPER.toBedResource(bedRepository.findByPatientId(patientId));
        return Optional.of(bedRes);
    }

    @Override
    public List<BedResource> findByHospitalId(Long id) {
        List<BedResource> result = new ArrayList<>();
        List<BedResource> beds = BED_MAPPER.toBedResources(bedRepository.findByRoomHospitalId(id));
        for(BedResource bed : beds) {
            if(bed.getValidFrom().before(new Date())) {
                result.add(bed);
            }
        }
        return result;
    }

    @Override
    public BedResource update(BedResource bedResource) {
        Bed bed = BED_MAPPER.fromBedResource(bedResource);
        roomRepository.findById(bedResource.getRoomId())
                .ifPresentOrElse(
                        bed::setRoom,
                        () -> {
                            throw new RuntimeException("Room not found");
                        }
                );
        return BED_MAPPER.toBedResource(bedRepository.save(bed));
    }

    @Override
    public Object findAuditsById(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Bed.class, id);
        List<BedResource> result = new ArrayList<>();
        for(Number revision : revisions) {
            Bed bed = auditReader.find(Bed.class, id, revision);
            result.add(BED_MAPPER.toBedResource(bed));
        }
        return result;
    }
}
