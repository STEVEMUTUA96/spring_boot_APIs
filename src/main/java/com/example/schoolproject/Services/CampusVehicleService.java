package com.example.schoolproject.Services;

import com.example.schoolproject.Models.CampusVehicle;
import com.example.schoolproject.dtos.VehicleRequestDtos;

import java.util.List;

public interface CampusVehicleService {

    CampusVehicle addVehicle(VehicleRequestDtos vehicleRequestDtos);

    List<CampusVehicle> getVehicles();

    CampusVehicle getVehicle(int id);

    CampusVehicle updateVehicle(int id, CampusVehicle campusVehicle);

    void deleteVehicle(int id);
}
