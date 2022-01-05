package com.example.schoolproject.Controllers;
import com.example.schoolproject.Models.Departments;
import com.example.schoolproject.Services.DepartmentService;
import com.example.schoolproject.dtos.DepartmentRequestDtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService){
        this.departmentService =departmentService;
    }

    @PostMapping
    public ResponseEntity<Departments> addDepartments(@RequestBody DepartmentRequestDtos departmentsRequestDtos){
        Departments departments1 = departmentService.addDepartments(departmentsRequestDtos);
       return new ResponseEntity<>(departments1, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Departments>> getDepartments(){
        List<Departments> departments =departmentService.getDepartments();
        return  ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartment(@PathVariable int id){
        Departments departments =departmentService.getDepartment(id);
        return ResponseEntity.ok(departments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departments> updateDepartments(@PathVariable int id, @RequestBody Departments departments){
        Departments departments1 =departmentService.updateDepartment(id, departments);
        return ResponseEntity.ok(departments1);
    }

    @DeleteMapping("/{id}")
    public  void deleteDepartment(@PathVariable int id){
         departmentService.deleteDepartment(id);
    }

    }
