package com.capgemini.spring.university.entity;

import java.io.Serializable;
import java.util.List;
import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable{

    private int id;
    private String name;
    private List<Course> courses;

}