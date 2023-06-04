package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {
    public boolean existsById(Long id);

    public List<Ambulance> findByHospitalId(Long id);
}
