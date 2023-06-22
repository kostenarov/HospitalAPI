package com.example.hospitalapi.controller.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DoctorResource extends PersonResource{
    private Long hospitalId;
    private List<OperationResource> operations;

    public List<OperationResource> getOperations() {
        return operations;
    }
}
