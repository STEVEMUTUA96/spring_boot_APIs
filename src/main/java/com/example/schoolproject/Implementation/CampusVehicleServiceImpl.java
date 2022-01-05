package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.CampusVehicle;
import com.example.schoolproject.Models.School;
import com.example.schoolproject.Repository.CampusVehicleRepository;
import com.example.schoolproject.Repository.SchoolRepository;
import com.example.schoolproject.Services.CampusVehicleService;
import com.example.schoolproject.dtos.VehicleRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class CampusVehicleServiceImpl implements CampusVehicleService {

    CampusVehicleRepository campusVehicleRepository;
    SchoolRepository schoolRepository;
    CampusVehicleServiceImpl(CampusVehicleRepository campusVehicleRepository, SchoolRepository schoolRepository){
       this.campusVehicleRepository = campusVehicleRepository;
       this.schoolRepository=schoolRepository;
   }

    @Override
    public CampusVehicle addVehicle(VehicleRequestDtos vehicleRequestDtos) {

        CampusVehicle campusVehicle= null;
        Optional<School>school = schoolRepository.findById(vehicleRequestDtos.getSchool_id());
        if(school.isPresent()) {
            campusVehicle = CampusVehicle.builder()
                    .vehicleId(vehicleRequestDtos.getVehicle_id())
                    .capacity(vehicleRequestDtos.getVehicle_capacity())
                    .cubicCapacity(vehicleRequestDtos.getCubic_capacity())
                    .vehicleMake(vehicleRequestDtos.getVehicle_make())
                    .vehicleName(vehicleRequestDtos.getVehicle_name())
                    .vehicleType(vehicleRequestDtos.getVehicle_type())
                    .yearOfManufacturer(vehicleRequestDtos.getYear_of_manufacturer())
                    .school(school.get())
                    .build();
        }
            return campusVehicleRepository.save(campusVehicle);

    }

    @Override
    public List<CampusVehicle> getVehicles() {
        return campusVehicleRepository.findAll();
    }

    @Override
    public CampusVehicle getVehicle(int id) {
        Optional<CampusVehicle> campusVehicle = campusVehicleRepository.findById(id);
        return campusVehicle.get();
    }

    @Override
    public CampusVehicle updateVehicle(int id, CampusVehicle campusVehicle) {
       CampusVehicle campusVehicle1 =getVehicle(id);
       campusVehicle1.setVehicleName(campusVehicle.getVehicleName());
       campusVehicle1.setVehicleMake(campusVehicle.getVehicleMake());
       campusVehicle1.setVehicleType(campusVehicle.getVehicleType());
       campusVehicle1.setCapacity(campusVehicle.getCapacity());
       campusVehicle1.setYearOfManufacturer(campusVehicle.getYearOfManufacturer());
       campusVehicle1.setCubicCapacity(campusVehicle.getCubicCapacity());
        return campusVehicleRepository.save(campusVehicle1);
    }

    @Override
    public void deleteVehicle(int id) {
       campusVehicleRepository.deleteById(id);

    }
}
