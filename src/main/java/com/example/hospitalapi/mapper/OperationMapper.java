package com.example.hospitalapi.mapper;

import com.example.hospitalapi.controller.resources.OperationResource;
import com.example.hospitalapi.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {
    public OperationMapper OPERATION_MAPPER = Mappers.getMapper(OperationMapper.class);

    @Mapping(source = "operation.id", target = "operationId")
    OperationResource toResource(Operation operation);

    @Mapping(source = "operationId", target = "operation.id")
    Operation toEntity(OperationResource operationResource);
}
