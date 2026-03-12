package com.capgemini.java_adv.framework.springcore;

import java.io.Serializable;
import java.util.List;

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

    private List<Student> students;
}