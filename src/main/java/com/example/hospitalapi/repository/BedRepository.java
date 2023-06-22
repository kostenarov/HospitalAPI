package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
    Bed findByPatientId(Long id);

    List<Bed> findByRoomId(Long id);

    List<Bed> findByRoomHospitalId(Long id);

    void deleteAllByRoomId(Long id);
}
