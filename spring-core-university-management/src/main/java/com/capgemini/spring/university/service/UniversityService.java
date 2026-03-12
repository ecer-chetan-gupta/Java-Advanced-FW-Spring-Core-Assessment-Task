package com.capgemini.spring.university.service;

import java.io.Serializable;
import java.util.*;

import com.capgemini.spring.university.entity.*;

public class UniversityService implements Serializable{

    Map<Integer, Department> departments = new HashMap<>();
    Map<Integer, Course> courses = new HashMap<>();
    Map<Integer, Student> students = new HashMap<>();

    int deptId = 101;
    int courseId = 501;
    int studentId = 901;

    public void addDepartment(String name) {

        Department dept = new Department();
        dept.setId(deptId++);
        dept.setName(name);
        dept.setCourses(new ArrayList<>());

        departments.put(dept.getId(), dept);

        System.out.println("Department added successfully");
        System.out.println("Department ID: " + dept.getId());
        System.out.println("Name: " + dept.getName());
    }

    public void addCourse(int departmentId, String courseName, int credits) {

        Department dept = departments.get(departmentId);

        Course c = new Course(courseId++, courseName, credits);

        courses.put(c.getId(), c);
        dept.getCourses().add(c);

        System.out.println("Course added successfully");
        System.out.println("Course ID: " + c.getId());
        System.out.println("Course Name: " + c.getCourseName());
        System.out.println("Credits: " + c.getCredits());
        System.out.println("Department: " + dept.getName());
    }

    public void addStudent(String name, String email, String phone, int departmentId) {

        Department dept = departments.get(departmentId);

        StudentProfile profile = new StudentProfile(301, email, phone);

        Student student = new Student();
        student.setId(studentId++);
        student.setName(name);
        student.setProfile(profile);
        student.setDepartment(dept);
        student.setCourses(new HashSet<>());

        students.put(student.getId(), student);

        System.out.println("Student added successfully");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getName());

        System.out.println("\nProfile:");
        System.out.println("  Email: " + email);
        System.out.println("  Phone: " + phone);

        System.out.println("\nDepartment:");
        System.out.println("  Name: " + dept.getName());
    }

    public void enrollStudent(int studentId, int courseId) {

        Student s = students.get(studentId);
        Course c = courses.get(courseId);

        s.getCourses().add(c);

        System.out.println("Enrollment successful");
    }

    public void updateEmail(int studentId, String newEmail) {

        students.get(studentId).getProfile().setEmail(newEmail);

        System.out.println("Student email updated successfully");
    }

    public void deleteStudent(int studentId) {

        students.remove(studentId);

        System.out.println("Student deleted successfully");
    }

    public void displayStudentDetails(int studentId) {

        Student s = students.get(studentId);

        System.out.println("\nStudent ID: " + s.getId());
        System.out.println("Name: " + s.getName());

        System.out.println("\nProfile:");
        System.out.println("  Email: " + s.getProfile().getEmail());
        System.out.println("  Phone: " + s.getProfile().getPhone());

        System.out.println("\nDepartment:");
        System.out.println("  Name: " + s.getDepartment().getName());

        System.out.println("\nCourses Enrolled:");

        for (Course c : s.getCourses()) {
            System.out.println("  " + c.getCourseName()
                    + " (" + c.getCredits() + " Credits)");
        }
    }
}