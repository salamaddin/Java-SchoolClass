package com.bassetti.Bassetti2;

class Address {
	String addline1, addline2, city;
	int zipcode;

	Address(String addline1, String addline2, String city, int zipcode) {
		this.addline1 = addline1;
		this.addline2 = addline2;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	public void printAddress() {
		System.out.println("Adress line1:" +addline1);
		System.out.println("Adress line2:" +addline2);
		System.out.println("City:" +city);
		System.out.println("Zipcode:" +zipcode);
	}
}