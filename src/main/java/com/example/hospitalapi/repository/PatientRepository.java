package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public boolean existsById(Long id);

    public Patient findByBedId(Long id);

    public Patient findByOperationId(Long id);

    public List<Patient> findByBedRoomHospitalId(Long id);

    public List<Patient> findByBedRoomId(Long id);

    public void deleteAllByBedRoomId(Long id);

    public void deleteByBedId(Long id);
}
