package com.bassetti.Bassetti2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Branch {
	String branchName, branchCode;
	Address address;
	Principal principal;
	LinkedHashMap<String, Section> sections;
	HashMap<String, Teacher> teachers;

	public Branch(String branchName, String branchCode, String banchAddress) {

		this.branchName = branchName;
		this.branchCode = branchCode;

		// String address convert to arrays
		String[] vals = banchAddress.split(" ");
		int zipcode = Integer.parseInt(vals[3]);
		// creating object of Address for the branch address
		address = new Address(vals[0], vals[1], vals[2], zipcode);

		sections = new LinkedHashMap<String, Section>();
		teachers = new HashMap<String, Teacher>();

	}

	// add principal
	public void addPrincipal(String fName, String lName, int age, String gender) {

		principal = new Principal(fName, lName, age, gender);

	}

	// add principal degrees
	public void addPrincipalDegrees(String[] degrees) {

		for (int i = 0; i < degrees.length; i++) {
			principal.addDegrees(degrees[i]);
		}
	}

	// add principal addresses
	public void addPrincipalAddress(String[] address) {

		for (int i = 0; i < address.length; i++) {
			String[] vals = address[i].split(" ");
			int zipcode = Integer.parseInt(vals[3]);
			principal.addAddress(vals[0], vals[1], vals[2], zipcode);

		}
	}

	public void printPrincipalDetails() {
		System.out.println("--------Principal of " + branchName + " Branch-------");
		principal.printDetails();
		System.out.println("Principal Degrees " + principal.degrees);
	}

	// add sections
	public void addSection(String sectionName, String roomNumber, String floorNumber, String standard, String classType,
			int capacity) {
		Section temp = new Section(roomNumber, floorNumber, standard, classType, capacity);
		sections.put(sectionName, temp);
	}

	public void addStudentsForSection(String sectionName, String firstName, String lastName, int age, String gender) {
		sections.get(sectionName).addStudents(firstName, lastName, age, gender);
	}

	public void addStudentAddrressForSection(String sectionName, String line1, String line2, String city,
			Integer zipcode) {
		sections.get(sectionName).addStudentAddrress(line1, line2, city, zipcode);
	}

	// print student details
	public void printStudentdDetails() {
		for (String standard : sections.keySet()) {

			sections.get(standard).printSectionDetails();
		}
	}
	
	public void printAllStudentdDetails(String branchName) {
		System.out.println("Students List of "+branchName+" Branch");
		for (String standard : sections.keySet()) {

			sections.get(standard).printStudentDetails();;
		}
	}

	// add Teacher
	public void addTeacher(String sectionName, String firstName, String lastName, int age, String gender) {
		Teacher temp = new Teacher(firstName, lastName, age, gender);
		sections.get(sectionName).addTeacher(firstName, lastName, age, gender);
		teachers.put(sectionName, temp);
	}
	
	//set time table for each section
	public void addTimeTable(String sectionName,String branchName,String day, String time[], String[] classDetails ) {
		
		sections.get(sectionName).addTimeTable( day, time, classDetails);
	}
	
	//print time table
	public void prinTimetable(String sectionName) {
	
		
		System.out.println(sectionName);
		
		sections.get(sectionName).printTimeTable();
	}
	

	// add Teacher address
	public void addTeacherAddress(String sectionName, String line1, String line2, String city, Integer zipcode) {

		teachers.get(sectionName).addAddress(line1, line2, city, zipcode);

	}

	// add Teacher Subject
	public void addTeacherSubject(String sectionName, String subject) {
		teachers.get(sectionName).addSubject(subject);
	}

	// add teacher degrees
	public void addTeacherDegrees(String sectionName, String degrees) {
		teachers.get(sectionName).addDegrees(degrees);
	}

	// print teachers details
	int i = 1;

	public void printTeacherDetails() {
		for (String standard : teachers.keySet()) {
			System.out.println();
			System.out.println("------Teacher " + (i++) + "-----");
			teachers.get(standard).printTeacherDetails();
		}

	}

}
