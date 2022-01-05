package com.example.schoolproject.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class   CampusVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identity;
    private String vehicleName;
    private String vehicleMake;
    private String yearOfManufacturer;
    private String capacity;
    private String cubicCapacity;
    private String vehicleType;
    private String vehicleId;

    @ManyToOne
    @JoinColumn
    private  School school;
}
