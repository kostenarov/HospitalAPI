package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.repository.DoctorRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.DoctorMapper.DOCTOR_MAPPER;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository DoctorRepository;
    private final HospitalRepository hospitalRepository;
    @Override
    public List<DoctorResource> findAll() {
        return DOCTOR_MAPPER.toDoctorResources(DoctorRepository.findAll());
    }

    @Override
    public DoctorResource save(DoctorResource doctorResource) {
        Doctor doctor = DOCTOR_MAPPER.fromDoctorResource(doctorResource);
        hospitalRepository.findById(doctorResource.getHospitalId())
                .ifPresentOrElse(
                        doctor::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital not found");
                        }
                );
        doctor.setOperations(null);
        return DOCTOR_MAPPER.toDoctorResource(DoctorRepository.save(doctor));
    }

    @Override
    public DoctorResource findById(Long id) {
        return DOCTOR_MAPPER.toDoctorResource(DoctorRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        DoctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorResource> findByHospitalId(Long id) {
        return DOCTOR_MAPPER.toDoctorResources(DoctorRepository.findByHospitalId(id));
    }

    @Override
    public DoctorResource update(DoctorResource doctorResource) {
        Doctor doctor = DOCTOR_MAPPER.fromDoctorResource(doctorResource);
        hospitalRepository.findById(doctorResource.getHospitalId())
                .ifPresentOrElse(
                        doctor::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital not found");
                        }
                );
        if(doctorResource.getId() == null)
            throw new RuntimeException("Id is null");
        if(!DoctorRepository.existsById(doctorResource.getId()))
            throw new RuntimeException("Doctor not found");
        return DOCTOR_MAPPER.toDoctorResource(DoctorRepository.save(doctor));
    }
}
