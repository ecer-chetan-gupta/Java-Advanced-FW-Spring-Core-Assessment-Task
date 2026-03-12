package com.capgemini.employee_idcard.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.employee_idcard.service.EmployeeService;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeService service = context.getBean("employeeService", EmployeeService.class);

		service.addEmployee();

		service.updateIssueDate("2025-01-15");

		service.deleteEmployee();
	}

}