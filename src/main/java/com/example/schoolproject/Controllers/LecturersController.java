package com.example.schoolproject.Controllers;
import com.example.schoolproject.Models.Lecturers;
import com.example.schoolproject.Services.LecturerServices;
import com.example.schoolproject.dtos.LecturerRequestDtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecturers")
public class LecturersController {

    LecturerServices lecturerServices;

    LecturersController(LecturerServices lecturerServices){
        this.lecturerServices=lecturerServices;
    }

    @PostMapping
    public ResponseEntity<Lecturers> addLecturer(@RequestBody LecturerRequestDtos lecturerRequestDtos){
        Lecturers lecturers1 =lecturerServices.addLecturer(lecturerRequestDtos);
        return new ResponseEntity<>(lecturers1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Lecturers>> getLecturer(){
        List<Lecturers>lecturers =lecturerServices.getLecturers();
        return ResponseEntity.ok(lecturers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturers> getLecturer(@PathVariable int id){
        Lecturers lecturers =lecturerServices.getLecturer(id);
        return ResponseEntity.ok(lecturers);
    }
    @PutMapping("/{id}")
   public ResponseEntity<Lecturers> updateLecturer(@PathVariable int id,  @RequestBody Lecturers lecturers){
        Lecturers lecturers1 = lecturerServices.updateLecturer(id, lecturers);
         return ResponseEntity.ok(lecturers1);
    }


    @DeleteMapping("/{id}")
    public  void  deleteLecturer(@PathVariable int id){
        lecturerServices.deleteLecturer(id);
    }
}
