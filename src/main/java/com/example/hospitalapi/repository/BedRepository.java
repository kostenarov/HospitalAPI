package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
    public Bed findByPatientId(Long id);

    public List<Bed> findByRoomId(Long id);

    public List<Bed> findByRoomHospitalId(Long id);

    public void deleteAllByRoomId(Long id);
}
