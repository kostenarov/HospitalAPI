package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomService RoomService;
    @Override
    public List<Room> findAll() {
        return RoomService.findAll();
    }

    @Override
    public Room save(Room room) {
        return RoomService.save(room);
    }

    @Override
    public Room findById(Long id) {
        return RoomService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        RoomService.deleteById(id);
    }

    @Override
    public List<Room> findByHospitalId(Long id) {
        return RoomService.findByHospitalId(id);
    }
}
