package com.example.schoolproject.Controllers;

import com.example.schoolproject.Models.Units;
import com.example.schoolproject.Services.UnitServices;
import com.example.schoolproject.dtos.UnitRequestDtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitsController {
    UnitServices unitServices;
    UnitsController(UnitServices unitServices){
        this.unitServices =unitServices;
    }

    @PostMapping
    public ResponseEntity<Units> addUnits(@RequestBody UnitRequestDtos unitRequestDtos){
        Units units1 =unitServices.addUnits(unitRequestDtos);
        return new ResponseEntity<>(units1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Units>> getUnits(){
        List<Units> units =unitServices.getUnits();
        return ResponseEntity.ok(units);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Units> getUnit(@PathVariable int id){
        Units units =unitServices.getUnit(id);
        return ResponseEntity.ok(units);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Units> updateUnits(@PathVariable int id, @RequestBody Units units){
        Units units1 =unitServices.updateUnits(id,units);
        return ResponseEntity.ok(units1);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable int id){
        unitServices.deleteUnit(id);
    }
}
