package com.capgemini.spring.university.entity;

import java.io.Serializable;
import java.util.Set;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private int id;
    private String name;
    private StudentProfile profile;
    private Department department;
    private Set<Course> courses;
}