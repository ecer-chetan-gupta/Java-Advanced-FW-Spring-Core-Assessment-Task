package com.capgemini.spring.university.entity;

import java.io.Serializable;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    private int id;
    private String courseName;
    private int credits;

}