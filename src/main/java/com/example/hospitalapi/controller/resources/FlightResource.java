package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FlightResource {
    private String flightNumber;
    private String departure;
    private String arrival;
    private Timestamp departureTime;
    private float price;
}
