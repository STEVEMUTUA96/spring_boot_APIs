package com.example.schoolproject.Services;

import com.example.schoolproject.Models.Units;
import com.example.schoolproject.dtos.UnitRequestDtos;


import java.util.List;


public interface UnitServices {
    Units addUnits(UnitRequestDtos unitRequestDtos);
    List<Units> getUnits();
    Units getUnit(int id);
    Units updateUnits(int id, Units units);
    void deleteUnit(int id);
}
