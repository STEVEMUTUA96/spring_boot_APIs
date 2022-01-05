package com.example.schoolproject.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lecturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int identity;
    private String firstName;
    private String lastName;
    private String emailAddress;

    @ManyToOne
    @JoinColumn
    private School school;
}