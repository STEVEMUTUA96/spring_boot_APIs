package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.Courses;
import com.example.schoolproject.Models.Departments;
import com.example.schoolproject.Repository.CourseRepository;
import com.example.schoolproject.Repository.DepartmentRepository;
import com.example.schoolproject.Services.CourseServices;
import com.example.schoolproject.dtos.CourseRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class CourseServiceImplementation implements CourseServices {

    CourseRepository courseRepository;
    DepartmentRepository departmentRepository;

    CourseServiceImplementation(CourseRepository courseRepository, DepartmentRepository departmentRepository){
        this.courseRepository=courseRepository;
        this.departmentRepository=departmentRepository;
    }

    @Override
    public Courses addCourse(CourseRequestDtos courseRequestDtos){
        Courses courses=null;
        Optional<Departments> departments=departmentRepository.findById(courseRequestDtos.getDepartment_id());
        if(departments.isPresent()){
            courses=Courses.builder()
                    .description(courseRequestDtos.getCourse_description())
                    .name(courseRequestDtos.getCourse_name())
                    .numberOfStudent(courseRequestDtos.getNumber_of_student())
                    .department(departments.get())
                    .build();
        }
        return courseRepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses viewCourse(int id) {
        Optional<Courses>courses =courseRepository.findById(id);
        return  courses.get();
    }


    @Override
    public Courses UpdateCourse(int id, Courses courses) {
        Courses courses1 =viewCourse(id);
        courses1.setName(courses.getName());
        courses1.setDescription(courses.getDescription());
        courses1.setNumberOfStudent(courses.getNumberOfStudent());
        return courseRepository.save(courses1);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }


}
