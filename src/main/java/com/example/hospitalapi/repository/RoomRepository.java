package com.example.hospitalapi.repository;

import com.example.hospitalapi.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public List<Room> findByHospitalId(Long id);

    List<Room> findAllByHospitalId(Long id);
}
