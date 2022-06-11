package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.List;

public class Human {
	String firstName, lastName, gender;
	int age;
	static Human nomad;
	static int maxAddCnt = 0;
	List<Address> addresses;

	Human(String firstName, String lastName, int age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;

		addresses = new ArrayList<Address>();
	}

	public void addAddress(String line1, String line2, String city, Integer zipcode) {

		Address temp = new Address(line1, line2, city, zipcode);
		addresses.add(temp);
		

	}

	public void printDetails() {
		System.out.println("First Name: " + this.firstName);
		System.out.println("Last Name: " + this.lastName);
		System.out.println("Gender: " + this.gender);
		System.out.println("Age " + this.age);

	}
	
	public void printAdresses() {
		for (int i = 0; i < addresses.size(); i++) {
			System.out.println("--------Adress # " + (i + 1) + "----------");
			addresses.get(i).printAddress();
			System.out.println("--------------------------");
		}
	}

}
