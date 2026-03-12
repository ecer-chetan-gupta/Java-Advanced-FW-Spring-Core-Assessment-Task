package com.capgemini.employee_idcard.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private int id;
	private String name;
	private String department;

	private IDCard idCard;

}