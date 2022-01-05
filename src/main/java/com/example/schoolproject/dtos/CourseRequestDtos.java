package com.example.schoolproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseRequestDtos {
    private int identity;
    private String course_name;
    private String course_description;
    private  int number_of_student;
    private  int department_id;
}
