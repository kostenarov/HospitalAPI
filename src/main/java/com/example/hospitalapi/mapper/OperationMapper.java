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
    OperationResource toOperationResource(Operation operation);

    @Mapping(source = "operationId", target = "operation.id")
    Operation fromOperationResource(OperationResource operationResource);

    @Mapping(source = "operation.id", target = "operationId")
    List<OperationResource> toOperationResources(List<Operation> operation);

    @Mapping(source = "operationId", target = "operation.id")
    List<Operation> fromOperationResources(List<OperationResource> operationResource);
}
