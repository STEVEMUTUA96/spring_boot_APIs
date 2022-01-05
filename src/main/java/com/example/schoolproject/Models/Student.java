package com.example.schoolproject.Models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int identity;
    private String firstName;
    private String secondName;
    private String idNumber;
    private String emailAddress;
    private String telNumber;

    @ManyToOne
    @JoinColumn
    private Courses  courses;


}
