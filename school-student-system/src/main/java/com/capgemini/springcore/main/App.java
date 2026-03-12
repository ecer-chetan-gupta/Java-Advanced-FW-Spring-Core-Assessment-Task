package com.capgemini.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.entity.School;
import com.capgemini.springcore.entity.Student;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		School school = context.getBean("school", School.class);

		System.out.println("School added successfully");

		System.out.println("School ID: " + school.getId());
		System.out.println("Name: " + school.getName());
		System.out.println("City: " + school.getCity());

		System.out.println("\nStudents:");

		for (Student s : school.getStudents()) {
			System.out.println("  " + s.getName() + " - Grade " + s.getGrade());
		}

	}
}