package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    public boolean existsById(Long id);

    public Operation findByPatientId(Long id);

    public List<Operation> findByDoctorId(Long id);

    public List<Operation> findByOperationDate(java.sql.Date date);

    public List<Operation> findAllByHospitalId(Long id);

    public void deleteAllByHospitalId(Long id);

    public List<Operation> findByHospitalId(Long id);

    public void deleteAllByDoctorId(Long id);

    public boolean existsByPatientId(Long id);
}
