package com.example.schoolproject.Repository;

import com.example.schoolproject.Models.CampusVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusVehicleRepository extends JpaRepository<CampusVehicle, Integer> {
}
