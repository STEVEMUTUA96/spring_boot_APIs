package com.example.schoolproject.Repository;

import com.example.schoolproject.Models.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturers, Integer> {
}
