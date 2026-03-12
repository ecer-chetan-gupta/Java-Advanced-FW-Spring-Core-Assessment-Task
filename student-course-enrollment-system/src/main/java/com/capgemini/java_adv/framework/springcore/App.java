package com.capgemini.java_adv.framework.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Student student = (Student) context.getBean("student1");

		System.out.println("Enrollment successful");
		System.out.println();

		System.out.println("Student ID: " + student.getId());
		System.out.println("Name: " + student.getName());
		System.out.println();
		System.out.println("Courses Enrolled:");

		for (Course course : student.getCourses()) {
			System.out.println("  " + course.getCourseName() + " (" + course.getCredits() + " Credits)");
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}