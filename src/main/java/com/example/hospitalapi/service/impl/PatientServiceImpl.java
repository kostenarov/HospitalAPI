package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientService PatientService;
    @Override
    public List<Patient> findAll() {
        return PatientService.findAll();
    }

    @Override
    public Patient save(Patient patient) {
        return PatientService.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return PatientService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        PatientService.deleteById(id);
    }

    @Override
    public List<Patient> findByHospitalId(Long id) {
        return PatientService.findByHospitalId(id);
    }

    @Override
    public List<Patient> findByRoomId(Long id) {
        return PatientService.findByRoomId(id);
    }

    @Override
    public List<Patient> findByBedId(Long id) {
        return PatientService.findByBedId(id);
    }

    @Override
    public List<Patient> findByOperationId(Long id) {
        return PatientService.findByOperationId(id);
    }
}
