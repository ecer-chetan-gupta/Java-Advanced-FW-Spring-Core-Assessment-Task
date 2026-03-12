package com.capgemini.springcore.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class School implements Serializable {

	private int id;
	private String name;
	private String city;
	private List<Student> students;

}