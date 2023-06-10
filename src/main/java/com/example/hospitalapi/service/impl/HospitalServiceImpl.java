package com.example.hospitalapi.service.impl;

import com.example.hospitalapi.controller.resources.HospitalResource;
import com.example.hospitalapi.entity.Hospital;
import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.repository.*;
import com.example.hospitalapi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospitalapi.mapper.HospitalMapper.HOSPITAL_MAPPER;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    private final OperationRepository operationRepository;
    private final AmbulanceRepository ambulanceRepository;
    private final RoomRepository roomRepository;
    private final DoctorRepository doctorRepository;
    private final BedRepository bedRepository;

    @Override
    public List<HospitalResource> findAll() {
        return HOSPITAL_MAPPER.toHospitalResources(hospitalRepository.findAll());
    }

    @Override
    public HospitalResource save(HospitalResource hospitalResource) {
        Hospital hospital = HOSPITAL_MAPPER.fromHospitalResource(hospitalResource);
        if(hospitalRepository.existsByName(hospital.getName())) {
            throw new RuntimeException("Hospital with name " + hospital.getName() + " already exists");
        }
        hospital.setRooms(null);
        hospital.setAmbulances(null);
        hospital.setDoctors(null);
        hospital.setOperations(null);
        return HOSPITAL_MAPPER.toHospitalResource(hospitalRepository.save(hospital));
    }

    @Override
    public HospitalResource findById(Long id) {
        Hospital hospital = hospitalRepository.findById(id).get();
        hospital.setRooms(roomRepository.findAllByHospitalId(id));
        hospital.setAmbulances(ambulanceRepository.findAllByHospitalId(id));
        hospital.setDoctors(doctorRepository.findAllByHospitalId(id));
        hospital.setOperations(operationRepository.findAllByHospitalId(id));

        return HOSPITAL_MAPPER.toHospitalResource(hospitalRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public HospitalResource update(HospitalResource hospitalResource) {
        Hospital hospital = HOSPITAL_MAPPER.fromHospitalResource(hospitalResource);
        if(!hospitalRepository.existsById(hospital.getId())) {
            throw new RuntimeException("Hospital with id " + hospital.getId() + " does not exist");
        }
        return HOSPITAL_MAPPER.toHospitalResource(hospitalRepository.save(hospital));
    }
}
