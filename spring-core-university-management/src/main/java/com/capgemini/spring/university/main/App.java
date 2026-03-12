package com.capgemini.spring.university.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.spring.university.entity.Course;
import com.capgemini.spring.university.entity.Student;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Student student = context.getBean("student", Student.class);

		System.out.println("Student ID: " + student.getId());
		System.out.println("Name: " + student.getName());

		System.out.println("\nProfile:");
		System.out.println("  Email: " + student.getProfile().getEmail());
		System.out.println("  Phone: " + student.getProfile().getPhone());

		System.out.println("\nDepartment:");
		System.out.println("  Name: " + student.getDepartment().getName());

		System.out.println("\nCourses Enrolled:");

		for (Course c : student.getCourses()) {

			System.out.println("  " + c.getCourseName() + " (" + c.getCredits() + " Credits)");
		}

	}
}