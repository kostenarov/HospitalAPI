package com.example.hospitalapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    private String flightNumber;

    private String departure;

    private String arrival;

    private Timestamp departureTime;
}
