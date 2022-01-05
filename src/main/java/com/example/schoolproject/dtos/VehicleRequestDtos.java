package com.example.schoolproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VehicleRequestDtos {
    private int identity;
    private String vehicle_name;
    private String vehicle_make;
    private String year_of_manufacturer;
    private String vehicle_capacity;
    private String cubic_capacity;
    private String vehicle_type;
    private String vehicle_id;
    private int school_id;
}
