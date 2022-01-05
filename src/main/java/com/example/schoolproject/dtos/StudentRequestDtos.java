package com.example.schoolproject.dtos;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentRequestDtos {
    private  int identity;
    private String first_name;
    private String second_name;
    private String id_number;
    private String email_address;
    private String tel_number;
    private int  course_id;
}
