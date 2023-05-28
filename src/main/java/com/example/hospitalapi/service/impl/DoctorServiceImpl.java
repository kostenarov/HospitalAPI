package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorService DoctorService;
    @Override
    public List<Doctor> findAll() {
        return DoctorService.findAll();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return DoctorService.save(doctor);
    }

    @Override
    public Doctor findById(Long id) {
        return DoctorService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        DoctorService.deleteById(id);
    }

    @Override
    public List<Doctor> findByHospitalId(Long id) {
        return DoctorService.findByHospitalId(id);
    }

    @Override
    public List<Doctor> findByOperationId(Long id) {
        return DoctorService.findByOperationId(id);
    }
}
