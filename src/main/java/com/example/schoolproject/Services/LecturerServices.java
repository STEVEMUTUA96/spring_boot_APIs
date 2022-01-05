package com.example.schoolproject.Services;

import com.example.schoolproject.Models.Lecturers;
import com.example.schoolproject.dtos.LecturerRequestDtos;

import java.util.List;

public interface LecturerServices {
    //Post lecturer
    Lecturers addLecturer(LecturerRequestDtos lecturerRequestDtos);

      //viewLecturer
    List<Lecturers> getLecturers();

    //view specific Lecturer
    Lecturers getLecturer( int id);

    //update lecturer
    Lecturers updateLecturer(int id, Lecturers lecturers);

    void deleteLecturer(int id);
}
