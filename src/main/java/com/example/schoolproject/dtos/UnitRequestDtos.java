package com.example.schoolproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnitRequestDtos {
    private int identity;
    private String unit_name;
    private String school_name;
    private String unit_description;
    private String unit_lecturer;
    private String unit_capacity;
    private String unit_duration;
    private  int course_id;
}
