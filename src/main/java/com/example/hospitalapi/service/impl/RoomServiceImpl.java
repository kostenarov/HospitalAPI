package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.repository.RoomRepository;
import com.example.hospitalapi.service.BedService;
import com.example.hospitalapi.service.HospitalService;
import com.example.hospitalapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.HospitalMapper.HOSPITAL_MAPPER;
import static com.example.hospitalapi.mapper.RoomMapper.ROOM_MAPPER;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository RoomRepository;
    private final HospitalService hospitalService;
    private final BedService bedService;

    @Override
    public List<RoomResource> findAll() {
        return ROOM_MAPPER.toRoomResources(RoomRepository.findAll());
    }

    @Override
    public RoomResource save(RoomResource roomResource) {
        Room room = ROOM_MAPPER.fromRoomResource(roomResource);
        HospitalResource hospital = hospitalService.findById(roomResource.getHospitalId());
        room.setHospital(HOSPITAL_MAPPER.fromHospitalResource(hospital));
        room.setBeds(roomResource.getBeds());
        return ROOM_MAPPER.toRoomResource(RoomRepository.save(room));
    }

    @Override
    public RoomResource findById(Long id) {
        return ROOM_MAPPER.toRoomResource(RoomRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        RoomRepository.deleteById(id);
    }

    @Override
    public List<RoomResource> findByHospitalId(Long id) {
        return ROOM_MAPPER.toRoomResources(RoomRepository.findByHospitalId(id));
    }

    @Override
    public RoomResource update(RoomResource roomResource) {
        Room room = ROOM_MAPPER.fromRoomResource(roomResource);
        HospitalResource hospital = hospitalService.findById(roomResource.getHospitalId());
        room.setHospital(HOSPITAL_MAPPER.fromHospitalResource(hospital));
        return ROOM_MAPPER.toRoomResource(RoomRepository.save(room));
    }
}
