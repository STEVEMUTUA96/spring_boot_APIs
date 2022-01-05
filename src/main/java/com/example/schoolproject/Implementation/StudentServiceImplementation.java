package com.example.schoolproject.Implementation;

import com.example.schoolproject.Models.Courses;
import com.example.schoolproject.Models.Student;
import com.example.schoolproject.Repository.CourseRepository;
import com.example.schoolproject.Repository.StudentRepository;
import com.example.schoolproject.Services.StudentService;
import com.example.schoolproject.dtos.StudentRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class StudentServiceImplementation implements StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;

    StudentServiceImplementation(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Student addStudent(StudentRequestDtos studentRequestDto) {
        Student student = null;
        Optional<Courses> course = courseRepository.findById(studentRequestDto.getCourse_id());
        if (course.isPresent()) {
            student = Student.builder()
                    .firstName(studentRequestDto.getFirst_name())
                    .emailAddress(studentRequestDto.getEmail_address())
                    .telNumber(studentRequestDto.getTel_number())
                    .secondName(studentRequestDto.getSecond_name())
                    .idNumber(studentRequestDto.getId_number())
                    .courses(course.get())
                    .build();

        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);

//        Student student1 = student.isPresent() ? student.get() : null;
//        return student1;
        return student.orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student student1 = getStudent(id);
        student1.setFirstName(student.getFirstName());
        student1.setSecondName(student.getSecondName());
        student1.setEmailAddress(student.getEmailAddress());
        student1.setIdNumber(student.getIdNumber());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);

    }
}
