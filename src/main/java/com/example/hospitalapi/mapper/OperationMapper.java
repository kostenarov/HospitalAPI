package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperationMapper {
    public OperationMapper OPERATION_MAPPER = Mappers.getMapper(OperationMapper.class);

    @Mapping(source = "operation.id", target = "operationId")
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.id", target = "doctorId")
    OperationResource toOperationResource(Operation operation);

    @Mapping(source = "operationId", target = "operation.id")
    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "doctorId", target = "doctor.id")
    Operation fromOperationResource(OperationResource operationResource);

    List<OperationResource> toOperationResources(List<Operation> operation);

    List<Operation> fromOperationResources(List<OperationResource> operationResource);
}
