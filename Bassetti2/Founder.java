package com.bassetti.Bassetti2;

import java.util.List;

public class Founder extends Human {
	List<Address> addresses;
	
	public Founder(String firstName, String lastName, int age, String gender) {
		super(firstName,lastName,age, gender);
	}
	
	public void addAddress(String line1, String line2, String city, Integer zipcode) {

		super.addAddress(line1, line2, city, zipcode);

	}
	
}
