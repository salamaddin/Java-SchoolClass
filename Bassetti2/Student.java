package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {

	static int count = 0;
	static int max = 0;
	static int maxAddress = 0;
	static Student eldest;
	static Student maxAddStudent;

	Student(String firstName, String lastName, int age, String gender) {
		super(firstName,lastName,age, gender);
		count++;

		if (max < age) {
			max = age;
			eldest = this;
		}

	}

	public void addAddress(String line1, String line2, String city, Integer zipcode) {

		super.addAddress(line1, line2, city, zipcode);
	
		if (maxAddress < addresses.size()) {
			maxAddress = addresses.size();
			maxAddStudent = this;
		}
	}

	public static void maxAddress() {
		System.out.println(maxAddStudent.firstName + " has the maximum numbers of addresses");
		maxAddStudent.printDetails();
		maxAddStudent.printAdresses();

	} 


	public static void writeExam() {
		System.out.println(eldest.firstName + " is writing exam");
	}

	public static void showEldestStudent() {
		System.out.println("Eldest Sudent is " + eldest.firstName + ""+eldest.lastName);
	}


}