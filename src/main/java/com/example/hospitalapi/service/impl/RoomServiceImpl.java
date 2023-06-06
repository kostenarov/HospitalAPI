package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.repository.HospitalRepository;
import com.example.hospitalapi.repository.RoomRepository;
import com.example.hospitalapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.RoomMapper.ROOM_MAPPER;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository RoomRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public List<RoomResource> findAll() {
        return ROOM_MAPPER.toRoomResources(RoomRepository.findAll());
    }

    @Override
    public RoomResource save(RoomResource roomResource) {
        Room room = ROOM_MAPPER.fromRoomResource(roomResource);
        hospitalRepository.findById(roomResource.getHospitalId())
                        .ifPresentOrElse(
                                room::setHospital,
                                () -> {
                                    throw new RuntimeException("Hospital not found");
                                }
                        );

        room.setBeds(null);
        return ROOM_MAPPER.toRoomResource(RoomRepository.save(room));
    }

    @Override
    public RoomResource findById(Long id) {
        Room room = RoomRepository.findById(id).get();
        return ROOM_MAPPER.toRoomResource(room);
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
        hospitalRepository.findById(roomResource.getHospitalId())
                .ifPresentOrElse(
                        room::setHospital,
                        () -> {
                            throw new RuntimeException("Hospital not found");
                        }
                );

        return ROOM_MAPPER.toRoomResource(RoomRepository.save(room));
    }
}
