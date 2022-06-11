package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.List;

public class Section {
	String roomNumber, floorNumber,sectionName,standard;
	String classType;
	int capacity;
	Teacher classTeacher;
	List<Student> students;
	Student temp;
	TimeTable timetable;
	
	public Section(String roomNumber, String floorNumber, String standard, String classType,
			int capacity) {
		super();
		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
		this.standard = standard;
		this.classType = classType;
		this.capacity = capacity;
		
		students = new ArrayList();
		timetable = new TimeTable();
	}
	
	public void addStudents(String firstName, String lastName, int age, String gender) {
		temp = new Student(firstName, lastName, age, gender);
		students.add(temp);
	}
	
	public void addStudentAddrress(String line1, String line2, String city, Integer zipcode) {
		temp.addAddress(line1, line2, city, zipcode);
	}
	
	//print Student details
	public void printStudentDetails() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("-----student-------");
			students.get(i).printDetails();
			students.get(i).printAdresses();
		}
	}
	
	//add time table
	public void addTimeTable(String day, String time[], String[] classDetails) {
		
		timetable.addTimeTable(day, time, classDetails);
		
	}
	
	//print time table
	public void printTimeTable() {
		timetable.printTimeTable();
	}

	
	public void addTeacher(String firstName, String lastName, int age, String gender ) {
		classTeacher = new Teacher(firstName, lastName, age, gender);
	}
	
	public void addTeacherDegrees(String degree) {
		classTeacher.addDegrees(degree);
	}
	
	public void addTeacherAddrress(String line1, String line2, String city, Integer zipcode) {
		classTeacher.addAddress(line1,line2,city,zipcode);
	}
	
	// print all section details
	public void printSectionDetails() {
		
		System.out.println("-----------Section ("+ standard +") Details---------");
		System.out.println("Room Number :"+roomNumber);
		System.out.println("floor Number :"+floorNumber);
		System.out.println("Standerd :"+standard);
		System.out.println("Class Type :"+classType);
		System.out.println("Capacity :"+capacity);
		System.out.println("Class Teacher : "+classTeacher.firstName+" "+classTeacher.lastName);
		System.out.println("---------Students List-------");
		
		for (int i = 0; i <students.size(); i++) {
			System.out.println("-----student "+(i+1)+"------");
			students.get(i).printDetails();
		}
	}	
	
}
