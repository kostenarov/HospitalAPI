package com.example.hospitalapi.controller.resources;

import com.example.hospitalapi.entity.Bed;
import lombok.Data;

import java.util.List;

@Data
public class RoomResource {
    private Long id;
    private Long hospitalId;
    private List<Bed> beds;
}
