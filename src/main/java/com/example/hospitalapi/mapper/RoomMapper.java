package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = BedMapper.class)
public interface RoomMapper {
    public RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "hospital.id", target = "hospitalId")
    RoomResource toRoomResource(Room room);

    @Mapping(source = "hospitalId", target = "hospital.id")
    Room fromRoomResource(RoomResource roomResource);

    List<RoomResource> toRoomResources(List<Room> roomList);

    List<Room> fromRoomResources(List<RoomResource> roomResourceList);
}
