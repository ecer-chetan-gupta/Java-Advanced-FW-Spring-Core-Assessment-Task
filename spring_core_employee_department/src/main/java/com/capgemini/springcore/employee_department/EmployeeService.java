package com.capgemini.springcore.employee_department;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService implements Serializable{

	private Map<Integer, Department> departmentMap = new HashMap<>();
	private Map<Integer, Employee> employeeMap = new HashMap<>();

	private int departmentIdCounter = 101;
	private int employeeIdCounter = 501;

	public String addDepartment(String name, String location) {
		Department department = new Department();
		department.setId(departmentIdCounter++);
		department.setName(name);
		department.setLocation(location);

		departmentMap.put(department.getId(), department);
		return "Department added successfully\nDepartment ID: " + department.getId();
	}

	public String addEmployee(String name, double salary, int departmentId) {
		if (salary <= 0) {
			return "Salary must be greater than 0";
		}

		Department department = departmentMap.get(departmentId);
		if (department == null) {
			return "Department does not exist";
		}

		Employee employee = new Employee();
		employee.setId(employeeIdCounter++);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setDepartment(department);

		employeeMap.put(employee.getId(), employee);

		return "Employee added successfully\n" + displayEmployee(employee);
	}

	public String updateEmployeeSalary(int employeeId, double newSalary) {
		Employee employee = employeeMap.get(employeeId);

		if (employee == null) {
			return "Employee does not exist";
		}

		if (newSalary <= 0) {
			return "Salary must be greater than 0";
		}

		employee.setSalary(newSalary);
		return "Salary updated successfully";
	}

	public String deleteEmployee(int employeeId) {
		Employee employee = employeeMap.remove(employeeId);

		if (employee == null) {
			return "Employee does not exist";
		}

		return "Employee deleted successfully";
	}

	public String searchEmployee(int employeeId) {
		Employee employee = employeeMap.get(employeeId);

		if (employee == null) {
			return "Employee not found";
		}

		return displayEmployee(employee);
	}

	public String displayEmployee(Employee employee) {
		return "Employee ID: " + employee.getId() + "\n" + "Name: " + employee.getName() + "\n" + "Salary: "
				+ (long) employee.getSalary() + "\n\n" + "Department:\n" + "  Name: "
				+ employee.getDepartment().getName() + "\n" + "  Location: " + employee.getDepartment().getLocation();
	}

	public Map<Integer, Department> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Map<Integer, Department> departmentMap) {
		this.departmentMap = departmentMap;
	}

	public Map<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}
}