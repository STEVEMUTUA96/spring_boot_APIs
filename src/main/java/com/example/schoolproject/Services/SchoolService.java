package com.example.schoolproject.Services;

import com.example.schoolproject.Models.School;

import java.util.List;

public interface SchoolService {
    School addSchool(School school);

    List <School> getSchools();

    School getSchool(int id);

    School updateSchool(int id, School school);

    void deleteSchool(int id);
}
