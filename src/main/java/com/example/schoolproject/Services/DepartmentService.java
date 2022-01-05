package com.example.schoolproject.Services;

import com.example.schoolproject.Models.Departments;
import com.example.schoolproject.dtos.DepartmentRequestDtos;


import java.util.List;

public interface DepartmentService {
    Departments addDepartments(DepartmentRequestDtos departmentRequestDtos);

    List<Departments> getDepartments();

    Departments getDepartment(int id);

    Departments updateDepartment(int id, Departments departments);

    void deleteDepartment(int id);
    }
