package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;
import com.example.hospitalapi.repository.*;
import com.example.hospitalapi.service.HospitalService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

import static com.example.hospitalapi.mapper.HospitalMapper.HOSPITAL_MAPPER;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    private final EntityManagerFactory entityManagerFactory;


    @Override
    public List<HospitalResource> findAll() {
        return HOSPITAL_MAPPER.toHospitalResources(hospitalRepository.findAll());
    }

    @Override
    public HospitalResource save(HospitalResource hospitalResource) {
        Hospital hospital = HOSPITAL_MAPPER.fromHospitalResource(hospitalResource);
        hospital.setCreatedDate(hospitalResource.getCreatedDate());
        if(hospitalRepository.existsByName(hospital.getName())) {
            throw new RuntimeException("Hospital with name " + hospital.getName() + " already exists");
        }
        return HOSPITAL_MAPPER.toHospitalResource(hospitalRepository.save(hospital));
    }

    @Override
    public Optional<HospitalResource> findById(Long id) {
        Hospital hospital = hospitalRepository.findById(id).get();
        return Optional.of(HOSPITAL_MAPPER.toHospitalResource(hospital));
    }

    @Override
    public void deleteById(Long id) {
        if(!hospitalRepository.existsById(id)) {
            throw new RuntimeException("Hospital with id " + id + " does not exist");
        }
        hospitalRepository.deleteById(id);
    }

    @Override
    public HospitalResource update(HospitalResource hospitalResource) {
        Hospital hospital = HOSPITAL_MAPPER.fromHospitalResource(hospitalResource);
        if(!hospitalRepository.existsById(hospital.getId())) {
            throw new RuntimeException("Hospital with id " + hospital.getId() + " does not exist");
        }
        return HOSPITAL_MAPPER.toHospitalResource(hospitalRepository.save(hospital));
    }

    @Override
    public Object findAllAudits(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Hospital.class, id);
        List<HospitalResource> result = new ArrayList<>();
        for(Number revision : revisions) {
            Hospital hospital = auditReader.find(Hospital.class, id, revision);
            result.add(HOSPITAL_MAPPER.toHospitalResource(hospital));
        }
        return result;
    }

    @Override
    public Object getUpUntilDate(String date) {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<?> revisions = auditReader.createQuery()
                .forRevisionsOfEntity(Hospital.class, true, true)
                .getResultList();

        List<HospitalResource> result = new ArrayList<>();

        for (Object revision : revisions) {
            if(((Hospital) revision).getCreatedDate() == null) {
                break;
            }

            if(((Hospital) revision).getCreatedDate().before(Timestamp.valueOf(date)) ||
                    ((Hospital) revision).getCreatedDate().equals(Timestamp.valueOf(date))) {
                result.add(HOSPITAL_MAPPER.toHospitalResource((Hospital) revision));
            }
        }

        return result;
    }
}
