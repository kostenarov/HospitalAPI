package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.repository.DoctorRepository;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.repository.OperationRepository;
import com.example.hospitalapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.hospitalapi.mapper.DoctorMapper.DOCTOR_MAPPER;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final OperationRepository operationRepository;
    @Override
    public List<DoctorResource> findAll() {
        return DOCTOR_MAPPER.toDoctorResources(doctorRepository.findAll());
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
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.save(doctor));
    }

    @Override
    public Optional<DoctorResource> findById(Long id) {
        return doctorRepository.findById(id).map(DOCTOR_MAPPER::toDoctorResource);
    }

    @Override
    public void deleteById(Long id) {
        operationRepository.deleteAllByDoctorId(id);
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorResource> findByHospitalId(Long id) {
        return DOCTOR_MAPPER.toDoctorResources(doctorRepository.findAllByHospitalId(id));
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
        if(!doctorRepository.existsById(doctorResource.getId()))
            throw new RuntimeException("Doctor not found");
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.save(doctor));
    }
}
