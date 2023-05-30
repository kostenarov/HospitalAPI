package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = HospitalMapper.class)
public interface RoomMapper {
    public RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "room.id", target = "roomId")
    RoomResource toRoomResource(Room room);

    @Mapping(source = "roomId", target = "room.id")
    Room fromRoomResource(RoomResource roomResource);

    @Mapping(source = "room.id", target = "roomId")
    List<RoomResource> toRoomResources(List<Room> roomList);

    @Mapping(source = "roomId", target = "room.id")
    List<Room> fromRoomResources(List<RoomResource> roomResourceList);
}
