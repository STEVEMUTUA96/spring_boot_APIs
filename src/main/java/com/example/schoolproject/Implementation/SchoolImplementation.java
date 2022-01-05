package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.School;
import com.example.schoolproject.Repository.SchoolRepository;
import com.example.schoolproject.Services.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SchoolImplementation implements SchoolService {

    SchoolRepository schoolRepository;

    SchoolImplementation(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }
    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(int id) {
        Optional<School> school =schoolRepository.findById(id);
      return school.get();
}

    @Override
    public School updateSchool(int id, School school) {
        School school1 =getSchool(id);
        school1.setSchoolName(school.getSchoolName());
        school1.setCounty(school.getCounty());
        school1.setPopulation(school.getPopulation());
        school1.setNoOfCourses(school.getNoOfCourses());
        school1.setNoOfLecturers(school.getNoOfLecturers());
        return schoolRepository.save(school1);
    }

    @Override
    public void deleteSchool(int id) {
      schoolRepository.deleteById(id);
    }
}
