package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsById(Long id);

    Patient findByBedId(Long id);

    Patient findByOperationId(Long id);

    List<Patient> findByBedRoomHospitalId(Long id);

    List<Patient> findByBedRoomId(Long id);

    void deleteAllByBedRoomId(Long id);

    void deleteByBedId(Long id);
}
