package com.example.schoolproject.Controllers;

import com.example.schoolproject.Models.Student;
import com.example.schoolproject.Services.StudentService;
import com.example.schoolproject.dtos.StudentRequestDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
   StudentService studentService;
    //CRUD
    //AddStudent --RETURN 201
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequestDtos studentRequestDto ){
        Student returnedStudent= studentService.addStudent(studentRequestDto);
        return new ResponseEntity<>(returnedStudent, HttpStatus.CREATED);
    }

    //viewStudent
    @GetMapping
    @CrossOrigin
    public ResponseEntity< List<Student> >getStudents(){
        List<Student> studentList= studentService.getStudents();
        return  ResponseEntity.ok(studentList);
    }

    //view specific Student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student=studentService.getStudent(id);
        return  ResponseEntity.ok(student);
    }

    //updateStudent
    @PutMapping("/{id}")
    public ResponseEntity<Student>  updateStudent(@PathVariable int id,  @RequestBody Student student){
        Student student1=studentService.updateStudent(id, student);
        return  ResponseEntity.ok(student1);
    }

    //delete
    @DeleteMapping("/{id}")
    public  void  deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
