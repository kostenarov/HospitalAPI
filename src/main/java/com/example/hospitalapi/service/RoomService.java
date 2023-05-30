package com.example.hospitalapi.service;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;

import java.util.List;

public interface RoomService {
    List<RoomResource> findAll();

    RoomResource save(RoomResource roomResource);

    RoomResource findById(Long id);

    void deleteById(Long id);

    List<RoomResource> findByHospitalId(Long id);
}
