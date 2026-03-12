package com.capgemini.java_adv.framework.springcore;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

	private int id;
	private String name;

	private Set<Course> courses;
}