package com.example.hospitalapi.controller.resources;

import lombok.Data;

@Data
public class BedResource {
    private Long id;
    private Long roomId;
    private Long patientId;
}
