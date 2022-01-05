package com.example.schoolproject.Controllers;

import com.example.schoolproject.Models.School;
import com.example.schoolproject.Services.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    SchoolService schoolService;

    SchoolController(SchoolService schoolService){
        this.schoolService =schoolService;
    }

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school){
        School school1 =schoolService.addSchool(school);
        return  new ResponseEntity<>(school1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> getSchools(){
        List<School>schools =schoolService.getSchools();
        return ResponseEntity.ok(schools);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<School> getSchool(@PathVariable int id){
       School school =schoolService.getSchool(id);
       return ResponseEntity.ok(school);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchools(@PathVariable int id, @RequestBody School school){
        School school1 =schoolService.updateSchool(id, school);
        return  ResponseEntity.ok(school1);
    }

    @DeleteMapping("/{id}")
    public  void  deleteSchool(@PathVariable int id){
        schoolService.deleteSchool(id);
    }

}
