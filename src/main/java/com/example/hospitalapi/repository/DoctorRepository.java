package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public boolean existsById(Long id);
    List<Doctor> findAllByHospitalId(Long id);
}
