package com.example.hospitalapi.controller;

import com.example.hospitalapi.controller.resources.RoomResource;
import com.example.hospitalapi.service.BedService;
import com.example.hospitalapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RoomResource roomResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/room/{id}")
                .buildAndExpand(roomService.save(roomResource).getId()).toUri()).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RoomResource roomResource) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/v1/room/{id}")
                .buildAndExpand(roomService.update(roomResource).getId()).toUri()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> findByHospitalId(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findByHospitalId(id));
    }
}
