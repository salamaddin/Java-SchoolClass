package com.bassetti.Bassetti2;

public class Subject {
	String subjectName, subjectCode;

	public Subject(String subjectName, String subjectCode) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}
	
	public void printSubjectsDetails() {
		System.out.println("Subject Name: "+subjectName);
		System.out.println("Subject Code: "+subjectCode);
	}
	
}
