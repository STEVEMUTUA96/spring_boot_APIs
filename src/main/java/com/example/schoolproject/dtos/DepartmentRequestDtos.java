package com.example.schoolproject.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentRequestDtos {
    private int identity;
    private String department_name;
    private String department_description;
    private String department_cod;
    private int number_of_lecturer;
    private  int school_id;
}
