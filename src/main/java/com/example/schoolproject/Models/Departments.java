package com.example.schoolproject.Models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identity;
    private String name;
    private String description;
    private String cod;
    private int numberOfLecturer;

    @ManyToOne
    @JoinColumn
    private School school;
}
