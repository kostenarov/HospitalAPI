package com.example.hospitalapi.repository;

import com.example.hospitalapi.controller.resources.FlightResource;
import com.example.hospitalapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAndArrival(String departure, String arrival);
}
