package com.example.schoolproject.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identity;
    private String unitName;
    private String school;
    private String unitDescription;
    private String unitLecturer;
    private String unitCapacity;
    private String unitDuration;

    @ManyToOne
    @JoinColumn
    private  Courses courses;
}
