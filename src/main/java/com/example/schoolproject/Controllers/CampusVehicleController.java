package com.example.schoolproject.Controllers;

import com.example.schoolproject.Models.CampusVehicle;
import com.example.schoolproject.Services.CampusVehicleService;
import com.example.schoolproject.dtos.VehicleRequestDtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class     CampusVehicleController {
    CampusVehicleService campusVehicleService;

    CampusVehicleController(CampusVehicleService campusVehicleService){
        this.campusVehicleService = campusVehicleService;
    }

    @PostMapping
    public ResponseEntity<CampusVehicle> addVehicles(@RequestBody VehicleRequestDtos vehicleRequestDtos){
        CampusVehicle campusVehicle1 = campusVehicleService.addVehicle(vehicleRequestDtos);
        return  new ResponseEntity<>(campusVehicle1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CampusVehicle>> getVehicles(){
       List <CampusVehicle> campusVehicle =campusVehicleService.getVehicles();
        return ResponseEntity.ok(campusVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampusVehicle> getVehicle(@PathVariable int id){
        CampusVehicle campusVehicle =campusVehicleService.getVehicle(id);
        return ResponseEntity.ok(campusVehicle);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CampusVehicle> updateVehicle(@PathVariable int id, @RequestBody CampusVehicle campusVehicle){
        CampusVehicle campusVehicle1 =campusVehicleService.updateVehicle(id, campusVehicle);
        return ResponseEntity.ok(campusVehicle1);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable  int id){
        campusVehicleService.deleteVehicle(id);
    }
}
