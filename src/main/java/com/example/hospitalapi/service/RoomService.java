package com.example.hospitalapi.service;

import com.example.hospitalapi.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room save(Room room);

    Room findById(Long id);

    void deleteById(Long id);

    List<Room> findByHospitalId(Long id);
}
