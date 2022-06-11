package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.List;

class Teacher extends Human{
	List<Address> addresses;
	List<String> degrees;
	List<Subject> subjects;
	
	
	Teacher(String firstName, String lastName, int age, String gender){
		super(firstName,lastName,age, gender);
		
		subjects = new ArrayList<Subject>();
		addresses = new ArrayList<Address>();
		degrees = new ArrayList<String>();
	}
	
	public void addSubject(String subject) {
		String[] vals = subject.split(" ");
		Subject temp = new Subject(vals[0],vals[1]);
		subjects.add(temp);
	}
	public void addDegrees(String subject) {
		degrees.add(subject);
	}
	
	public void addAddress(String line1, String line2, String city, Integer zipcode) {

		super.addAddress(line1, line2, city, zipcode);

	}
	
	public void printTeacherDetails() {
		printDetails();
		for (int i = 0; i < subjects.size(); i++) {
			subjects.get(i).printSubjectsDetails();	
		}
		System.out.println("Teacher Degrees: "+degrees);	
	}
	
//	public void printDetails() {
//		super.printDetails();
//		
//		//System.out.println("subject : "+subject);
//
//	}
	
}