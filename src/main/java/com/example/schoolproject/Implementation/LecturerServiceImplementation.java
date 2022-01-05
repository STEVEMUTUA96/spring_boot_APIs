package com.example.schoolproject.Implementation;
import com.example.schoolproject.Models.Lecturers;
import com.example.schoolproject.Models.School;
import com.example.schoolproject.Repository.LecturerRepository;
import com.example.schoolproject.Repository.SchoolRepository;
import com.example.schoolproject.Services.LecturerServices;
import com.example.schoolproject.dtos.LecturerRequestDtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class LecturerServiceImplementation implements LecturerServices {
  LecturerRepository lecturerRepository;
  SchoolRepository schoolRepository;

   LecturerServiceImplementation(LecturerRepository lecturerRepository, SchoolRepository schoolRepository){
      this.lecturerRepository =lecturerRepository;
      this.schoolRepository =schoolRepository;
  }

    @Override
    public Lecturers addLecturer(LecturerRequestDtos lecturerRequestDtos) {
       Lecturers lecturers =null;
       Optional<School>school =schoolRepository.findById(lecturerRequestDtos.getSchool_id());
       if(school.isPresent()){
           lecturers = Lecturers.builder()
                   .emailAddress(lecturerRequestDtos.getEmail_eddress())
                   .firstName(lecturerRequestDtos.getFirst_name())
                   .lastName(lecturerRequestDtos.getLast_name())
                   .school(school.get())
                   .build();
       }
        return lecturerRepository.save(lecturers);
    }

    @Override
    public List<Lecturers> getLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturers getLecturer(int id) {
        Optional<Lecturers>lecturers =lecturerRepository.findById(id);
        return lecturers.get();
    }

    @Override
    public Lecturers updateLecturer(int id, Lecturers lecturers) {
        Lecturers lecturers1 = getLecturer(id);
        lecturers1.setFirstName(lecturers.getFirstName());
        lecturers1.setLastName(lecturers.getLastName());
        lecturers1.setEmailAddress(lecturers.getEmailAddress());

        return lecturerRepository.save(lecturers1);
    }

    @Override
    public void deleteLecturer(int id) {
        lecturerRepository.deleteById(id);
    }


}
