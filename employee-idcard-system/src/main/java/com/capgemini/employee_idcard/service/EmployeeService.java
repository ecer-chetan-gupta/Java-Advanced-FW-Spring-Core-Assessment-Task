package com.capgemini.employee_idcard.service;

import com.capgemini.employee_idcard.entity.Employee;

public class EmployeeService {

	private Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// Add Employee
	public void addEmployee() {

		System.out.println("Employee added successfully");

		displayEmployee();
	}

	// Display
	public void displayEmployee() {

		System.out.println("ID: " + employee.getId());
		System.out.println("Name: " + employee.getName());
		System.out.println("Department: " + employee.getDepartment());

		System.out.println("ID Card:");
		System.out.println("  Card Number: " + employee.getIdCard().getCardNumber());
		System.out.println("  Issue Date: " + employee.getIdCard().getIssueDate());
	}

	// Update Issue Date
	public void updateIssueDate(String newDate) {

		employee.getIdCard().setIssueDate(newDate);

		System.out.println("IDCard updated successfully");
		displayEmployee();
	}

	// Delete Employee
	public void deleteEmployee() {

		employee = null;

		System.out.println("Employee deleted successfully");
	}

}