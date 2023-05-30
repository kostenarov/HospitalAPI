package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    public RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "room.id", target = "roomId")
    RoomResource toResource(Room room);

    @Mapping(source = "roomId", target = "room.id")
    Room toEntity(RoomResource roomResource);
}
