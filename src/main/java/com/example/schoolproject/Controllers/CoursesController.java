package com.example.schoolproject.Controllers;

import com.example.schoolproject.Models.Courses;
import com.example.schoolproject.Models.Lecturers;
import com.example.schoolproject.Services.CourseServices;
import com.example.schoolproject.Services.LecturerServices;
import com.example.schoolproject.dtos.CourseRequestDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    CourseServices courseServices;

    @PostMapping
    public ResponseEntity<Courses> addCourse(@RequestBody CourseRequestDtos courseRequestDtos){
        Courses courses1 = courseServices.addCourse(courseRequestDtos);
        return new ResponseEntity<>(courses1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses(){
       List<Courses> courses =courseServices.getAllCourses();
        return ResponseEntity.ok(courses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Courses> ViewCourse(@PathVariable int id){
      Courses courses =courseServices.viewCourse(id);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses>UpdateCourse(@PathVariable int id,  @RequestBody Courses courses){
        Courses courses1 =courseServices.UpdateCourse(id, courses);
        return ResponseEntity.ok(courses1);
    }


    @DeleteMapping("/{id}")
    public  void  deleteCourse(@PathVariable int id){
        courseServices.deleteCourse(id);
    }
}
