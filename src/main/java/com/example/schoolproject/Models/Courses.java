package com.example.schoolproject.Models;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identity;
    private String name;
    private String description;
    private  int numberOfStudent;
    /**
     *  Enhancing foreign key
     */

    @ManyToOne
    @JoinColumn
    private  Departments department;



}
