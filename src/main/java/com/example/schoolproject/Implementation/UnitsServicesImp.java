package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.Courses;
import com.example.schoolproject.Models.Units;
import com.example.schoolproject.Repository.CourseRepository;
import com.example.schoolproject.Repository.UnitsRepository;
import com.example.schoolproject.Services.UnitServices;
import com.example.schoolproject.dtos.UnitRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitsServicesImp implements UnitServices {
    UnitsRepository unitsRepository;
    CourseRepository courseRepository;
    UnitsServicesImp(UnitsRepository unitsRepository, CourseRepository courseRepository){
        this.unitsRepository =unitsRepository;
        this.courseRepository =courseRepository;
    }
    @Override
    public Units addUnits(UnitRequestDtos unitRequestDtos) {
        Units units =null;
        Optional<Courses>courses =courseRepository.findById(unitRequestDtos.getCourse_id());
        if(courses.isPresent()){
            units = Units.builder()
                    .unitName(unitRequestDtos.getUnit_name())
                    .unitCapacity(unitRequestDtos.getUnit_capacity())
                    .unitDuration(unitRequestDtos.getUnit_duration())
                    .unitDescription(unitRequestDtos.getUnit_description())
                    .unitLecturer(unitRequestDtos.getUnit_lecturer())
                    .school(unitRequestDtos.getSchool_name())
                    .courses(courses.get())
                    .build();

        }
        return unitsRepository.save(units);
    }

    @Override
    public List<Units> getUnits() {
        return unitsRepository.findAll();
    }

    @Override
    public Units getUnit(int id) {
        Optional<Units>units =unitsRepository.findById(id);
        return units.orElse(null);
    }

    @Override
    public Units updateUnits(int id, Units units) {
        Units units1 = getUnit(id);
        units1.setUnitName(units.getUnitName());
        units1.setSchool(units.getSchool());
        units1.setUnitCapacity(units.getUnitCapacity());
        units1.setUnitDescription(units.getUnitDescription());
        units1.setUnitDuration(units.getUnitDuration());
        units1.setUnitDescription(units.getUnitDescription());
        return unitsRepository.save(units1);
    }

    @Override
    public void deleteUnit(int id) {
        unitsRepository.deleteById(id);
    }
}
