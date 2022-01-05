package com.example.schoolproject.Repository;

import com.example.schoolproject.Models.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsRepository extends JpaRepository<Units, Integer> {
}
