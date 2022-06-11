package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.List;

public class Principal extends Human {
	List<String> degrees;
	List<Address> addresses;

	public Principal(String firstName, String lastName, int age, String gender) {
		super(firstName, lastName, age, gender);
		degrees = new ArrayList();
	}

	public void addAddress(String line1, String line2, String city, Integer zipcode) {

		super.addAddress(line1, line2, city, zipcode);

	}

	public void addDegrees(String subject) {
		degrees.add(subject);
	}

}
