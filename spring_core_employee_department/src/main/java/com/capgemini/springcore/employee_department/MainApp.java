package com.capgemini.springcore.employee_department;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		Department springDepartment = (Department) context.getBean("department");
		Employee springEmployee = (Employee) context.getBean("employee");

		// preload XML-configured department and employee into service maps
		service.getDepartmentMap().put(springDepartment.getId(), springDepartment);
		service.getEmployeeMap().put(springEmployee.getId(), springEmployee);

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== Employee Department System =====");
			System.out.println("1. Add Department");
			System.out.println("2. Add Employee");
			System.out.println("3. Search Employee");
			System.out.println("4. Update Employee Salary");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("Enter department name:");
				String deptName = sc.nextLine();

				System.out.println("Enter department location:");
				String deptLocation = sc.nextLine();

				System.out.println(service.addDepartment(deptName, deptLocation));
				break;

			case 2:
				sc.nextLine();
				System.out.println("Enter employee name:");
				String empName = sc.nextLine();

				System.out.println("Enter employee salary:");
				double salary = sc.nextDouble();

				System.out.println("Enter department ID:");
				int deptId = sc.nextInt();

				System.out.println(service.addEmployee(empName, salary, deptId));
				break;

			case 3:
				System.out.println("Enter employee ID:");
				int searchId = sc.nextInt();

				System.out.println(service.searchEmployee(searchId));
				break;

			case 4:
				System.out.println("Enter employee ID:");
				int empId = sc.nextInt();

				System.out.println("Enter new salary:");
				double newSalary = sc.nextDouble();

				System.out.println(service.updateEmployeeSalary(empId, newSalary));
				break;

			case 5:
				System.out.println("Enter employee ID:");
				int deleteId = sc.nextInt();

				System.out.println(service.deleteEmployee(deleteId));
				break;

			case 6:
				System.out.println("Exiting application...");
				sc.close();
				((ClassPathXmlApplicationContext) context).close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}