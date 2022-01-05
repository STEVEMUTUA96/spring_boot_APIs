package com.example.schoolproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturerRequestDtos {
    private  int identity;
    private String first_name;
    private String last_name;
    private String email_eddress;
    private  int school_id;
}
