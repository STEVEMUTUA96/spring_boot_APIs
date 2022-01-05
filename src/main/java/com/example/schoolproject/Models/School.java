package com.example.schoolproject.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int identity;
    private  String schoolName;
    private  String county;
    private  int population;
    private  int noOfCourses;
    private  int noOfLecturers;
}
