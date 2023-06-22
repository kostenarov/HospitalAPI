package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    boolean existsById(Long id);

    Operation findByPatientId(Long id);

    List<Operation> findByDoctorId(Long id);

    List<Operation> findByOperationDate(java.sql.Date date);

    List<Operation> findByHospitalId(Long id);

    void deleteAllByDoctorId(Long id);

    boolean existsByPatientId(Long id);
}
