package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.DoctorResource;
import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Operation;
import com.example.hospitalapi.repository.DoctorRepository;
import com.example.hospitalapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.DoctorMapper.DOCTOR_MAPPER;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository DoctorRepository;
    @Override
    public List<DoctorResource> findAll() {
        return DOCTOR_MAPPER.toDoctorResources(DoctorRepository.findAll());
    }

    @Override
    public DoctorResource save(DoctorResource doctor) {
        Doctor doctor1 = DOCTOR_MAPPER.fromDoctorResource(doctor);
        return DOCTOR_MAPPER.toDoctorResource(DoctorRepository.save(doctor1));
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
        return findAll().stream().filter(doctorResource -> doctorResource.getHospitalId().equals(id)).toList();
    }

    @Override
    public DoctorResource findByOperationId(Long id) {
        return findAll().stream().map(doctorResource -> {
            for(OperationResource temp : doctorResource.getOperations()){
                if(temp.getId().equals(id)){
                    return doctorResource;
                }
            }
            return null;
        }).toList().get(0);
    }

    @Override
    public DoctorResource update(DoctorResource doctorResource) {
        Doctor doctor = DOCTOR_MAPPER.fromDoctorResource(doctorResource);
        return DOCTOR_MAPPER.toDoctorResource(DoctorRepository.save(doctor));
    }
}
