package com.example.schoolproject.Services;

import com.example.schoolproject.Models.Courses;
import com.example.schoolproject.dtos.CourseRequestDtos;

import java.util.List;

public interface CourseServices {
    Courses addCourse(CourseRequestDtos courseRequestDtos);

    List<Courses> getAllCourses();

    Courses viewCourse(int id);

    Courses UpdateCourse(int id, Courses courses);

    void deleteCourse(int id);
}
