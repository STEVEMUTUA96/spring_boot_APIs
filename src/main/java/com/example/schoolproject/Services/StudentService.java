package com.example.schoolproject.Services;

import com.example.schoolproject.Models.Student;
import com.example.schoolproject.dtos.StudentRequestDtos;

import java.util.List;


public interface StudentService {
    //CRUD
    //AddStudent
    Student addStudent(StudentRequestDtos studentRequestDto );

    //viewStudent
    List<Student> getStudents();

    //view specific Student
    Student getStudent( int id);

    //updateStudent
    Student updateStudent(int id, Student student);

    //Delete
    void deleteStudent(int id);

}
