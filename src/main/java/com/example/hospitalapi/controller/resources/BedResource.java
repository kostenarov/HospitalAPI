package com.example.hospitalapi.controller.resources;

import lombok.Data;

import java.util.Date;

@Data
public class BedResource {
    private Long id;
    private Long roomId;
    private Long patientId;
    private Date modifiedDate;
    private Date ValidFrom;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(java.sql.Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getValidFrom() {
        return ValidFrom;
    }

    public void setValidFrom(java.sql.Date ValidFrom) {
        this.ValidFrom = ValidFrom;
    }
}
