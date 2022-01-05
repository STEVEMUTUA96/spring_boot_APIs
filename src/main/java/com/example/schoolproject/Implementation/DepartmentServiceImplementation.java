package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.Departments;
import com.example.schoolproject.Models.School;
import com.example.schoolproject.Repository.DepartmentRepository;
import com.example.schoolproject.Repository.SchoolRepository;
import com.example.schoolproject.Services.DepartmentService;
import com.example.schoolproject.dtos.DepartmentRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    DepartmentRepository departmentRepository;
    SchoolRepository schoolRepository;
    DepartmentServiceImplementation(DepartmentRepository departmentRepository, SchoolRepository schoolRepository){
        this.departmentRepository = departmentRepository;
        this.schoolRepository =schoolRepository;
    }

    @Override
    public Departments addDepartments(DepartmentRequestDtos departmentRequestDtos) {
        Departments departments=null;
        Optional<School>school =schoolRepository.findById(departmentRequestDtos.getSchool_id());
        if (school.isPresent()) {
            departments =Departments.builder()
                    .cod(departmentRequestDtos.getDepartment_cod())
                    .description(departmentRequestDtos.getDepartment_description())
                    .name(departmentRequestDtos.getDepartment_name())
                    .numberOfLecturer(departmentRequestDtos.getNumber_of_lecturer())
                    .school(school.get())
                    .build();
    }
        return departmentRepository.save(departments);
    }

    @Override
    public List<Departments> getDepartments() {
        return departmentRepository.findAll();
    }


    @Override
    public Departments getDepartment(int id) {
        Optional<Departments> departments =departmentRepository.findById(id);
        return departments.get();
    }


    @Override
    public Departments updateDepartment(int id, Departments departments  ) {
        Departments departments1 = getDepartment(id);
        departments1.setName(departments.getName());
        departments1.setDescription(departments.getDescription());
        departments1.setNumberOfLecturer(departments.getNumberOfLecturer());
        departments1.setCod(departments.getCod());
        return departmentRepository.save(departments1);
    }


    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);

    }
}
