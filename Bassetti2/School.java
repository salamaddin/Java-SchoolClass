package com.bassetti.Bassetti2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class School {
	String schoolName, boardofEducation;
	List<Founder> founders;
	HashMap<String, Branch> branches;
	List<Subject> subjects;

	public School(String schoolName, String boardofEducation) {
		this.schoolName = schoolName;
		this.boardofEducation = boardofEducation;
		founders = new ArrayList();
		branches = new HashMap();
		subjects = new ArrayList();

	}

	// add branches
	public void addBranches(String branchName, String branchCode, String branchAddress) {
		Branch temp = new Branch(branchName, branchCode, branchAddress);
		branches.put(branchName, temp);
	}

	// print total number of branches
	public void printAllBranches() {
		System.out.println("Total Brnaches : " + branches.size());
		for (String name : branches.keySet()) {
			System.out.println(schoolName+" ("+name+")");
		}
	}

	// add principal for the branch class
	public void addPrincipal(String branchName, String[] principal) {

		branches.get(branchName).addPrincipal(principal[0], principal[1], Integer.parseInt(principal[2]), principal[3]);
	}

	// add principal degree
	public void addPrincipalDegree(String branchName, String[] degree) {

		branches.get(branchName).addPrincipalDegrees(degree);
	}

	// add principal address
	public void addPrincipalAddress(String branchName, String[] address) {

		branches.get(branchName).addPrincipalAddress(address);
	}

	// add section details for the specific branch
	public void addSectionDetails( String branchName,String sectionName, String roomNumber, String floorNumber, String standard,
			String classType, int capacity) {

		branches.get(branchName).addSection(sectionName,roomNumber, floorNumber, standard, classType, capacity);
	}

	// add student for section
	public void addStudents(String branchName, String sectionName, String firstName, String lastName, int age, String gender) {
		branches.get(branchName).addStudentsForSection(sectionName,firstName, lastName, age, gender);
	}

	// add student address for section
	public void addStudentAddrres(String branchName,String sectionName, String line1, String line2, String city, Integer zipcode) {
		branches.get(branchName).addStudentAddrressForSection(sectionName,line1, line2, city, zipcode);
	}
	
	// print all student at specific brach
	public void printAllStudents(String branchName) {
		branches.get(branchName).printAllStudentdDetails(branchName);
	}

	// add teacher at branches
	public void addTeacher( String branchName,String sectionName, String firstName, String lastName, int age,
			String gender) {
		branches.get(branchName).addTeacher(sectionName, firstName, lastName, age, gender);
	}

	// add teacher address
	public void addTeacherAddress(String branchName,String sectionName, String line1, String line2, String city, Integer zipcode) {
		branches.get(branchName).addTeacherAddress(sectionName,line1, line2, city, zipcode);
	}

	// add teacher subject
	public void addTeacherSubject(String branchName,String sectionName, String subject) {
		branches.get(branchName).addTeacherSubject(sectionName,subject);
	}

	// add teacher degrees
	public void addTeacherDegrees(String branchName,String sectionName, String degrees) {
		branches.get(branchName).addTeacherDegrees(sectionName,degrees);
	}
	
	// add time table slot
	public void addTimeTable(String branchName, String sectionName,String day, String[] time, String[] classDetails ) {
		branches.get(branchName).addTimeTable(sectionName,branchName, day, time, classDetails);
	}
	
	// print time table
	public void printTimeTable(String branchname,String sectionName) {
		branches.get(branchname).prinTimetable(sectionName);
	}
	//to print specific  time slot 
	public void printSpecificTimeTableDetails(String branchName, String sectionName,String day, String time) {
		 branches.get(branchName).sections.get(sectionName).timetable.getSlotDetails(day,time);
	}

	// print branch details
	public void printBranchDetails(String branchName) {
		System.out.println(">>>>>>>>>>>>> Branch Name: " + branches.get(branchName).branchName + "  <<<<<<<<<<<<<");
		System.out.println("Branch Address:- ");
		branches.get(branchName).address.printAddress();
		branches.get(branchName).printPrincipalDetails();
		System.out.println("---------Teachers of " + branchName + " Branch --------");
		branches.get(branchName).printTeacherDetails();
		branches.get(branchName).printStudentdDetails();

	}

	// add founder
	public void addFounder(String firstName, String lastName, int age, String gender, String[] address) {

		Founder temp = new Founder(firstName, lastName, age, gender);

		for (int i = 0; i < address.length; i++) {
			String[] vals = address[i].split(" ");
			int zipcode = Integer.parseInt(vals[3]);
			temp.addAddress(vals[0], vals[1], vals[2], zipcode);
		}

		founders.add(temp);
	}

	// print founder details
	public void printFounderDetails() {
		for (int i = 0; i < founders.size(); i++) {
			System.out.println("--------Founder Details " + (i + 1) + "---------");
			founders.get(i).printDetails();
		}
	}

	// add subjects
	public void addSubjects(String[] subjects) {

		for (int i = 0; i < subjects.length; i++) {
			String vals[] = subjects[i].split("#");
			Subject temp = new Subject(vals[0], vals[1]);
			this.subjects.add(temp);
		}
	}

	// print all the subjects
	public void printSubjectDetails() {
		System.out.println("--------Subject Details---------");
		for (int i = 0; i < subjects.size(); i++) {
			System.out.print(subjects.get(i).subjectName);
			System.out.println(" " + subjects.get(i).subjectCode);
		}
	}

	public static void main(String args[]) {
		// creating object of School class
		School s = new School("Delhi Public School", "P.B");
		System.out.println(s.schoolName);

		String[] subjects = { "Chemistry # CHEM", "Bangla # BNG", "Mathematics # MATH", "Computer # COMP",
				"English # ENG", "Physics # PHYS", };
		String[] address1 = { "line1 line2 delhi 32245"
//				"line2 line66 delhi 32245"
		};
		String[] address2 = { "line2 line66 Kolkata 33245", "line3 line66 Kolkata 62245" };
		// initialize principal details for the specific branch
		String[] principalforkolkata = { "souvik", "Ghosh", "35", "Male" };
		String[] principalforDelhi = { "sumon", "maity", "35", "Male" };
		String[] degree = { "B.Tech", "M.Tech", "PhD " };
		String[] principalAdress1 = { "line2 line66 Delhi 33245", "line2 line66 kolkata 33245" };
		String[] principalAdress2 = { "line2 line66 mumbai 33245", "line2 line66 Delhi 33245" };

		// calling founder method
		s.addFounder("Pinkesh", "Barjatiya", 43, "Male", address1);
		s.addFounder("Bristy", "Roy", 33, "Female", address2);
		
		// calling subject method
		s.addSubjects(subjects);

		// initialize branches address
		String kolkatBranch = "line1 line66 Kolkata 33245";
		String DelhiBranch = "line2 line66 Delhi 33245";

		// calling Branch method
		s.addBranches("Kolkata", "dps1", kolkatBranch);
		s.addBranches("Delhi", "dps2", DelhiBranch);

		// creating object for principal of kolkata branch
		s.addPrincipal("Kolkata", principalforkolkata);
		s.addPrincipalDegree("Kolkata", degree);
		s.addPrincipalAddress("Kolkata", principalAdress2);

		// creating object for principal of Delhi branch
		s.addPrincipal("Delhi", principalforDelhi);
		s.addPrincipalDegree("Delhi", degree);
		s.addPrincipalAddress("Delhi", principalAdress1);

		// calling addSection method and providing information for kolkata branch and specific section
		// provide the first parameter is branch name second is for section to add section details
		s.addSectionDetails("Kolkata","class Five", "r01", "First floor", "class 5", "class Room", 50);
		s.addSectionDetails("Kolkata","class Six", "r02", "First floor", "class 6", "class Room", 50);
		s.addSectionDetails("Kolkata","class Seven", "r03", "Second floor", "class 7", "class Room", 50);
		s.addSectionDetails("Kolkata","class Eight", "r04", "Second floor", "class 8", "class Room", 50);

		// calling addSection method and providing information for Delhi branch
		s.addSectionDetails("Delhi","class Five", "r01", "First floor", "class 5", "class Room", 50);
		s.addSectionDetails("Delhi","class Six", "r02", "First floor", "class 6", "class Room", 50);
		s.addSectionDetails("Delhi","class Seven", "r03", "Second floor", "class 7", "class Room", 50);
		s.addSectionDetails("Delhi","class Eight", "r04", "Second floor", "class 8", "class Room", 50);

		// Initialize student information
		String[] firstName = { "salam", "sumon", "soharab", "neha" };
		String[] lastName = { "sk", "mondal", "sk", "biswas" };
		int[] age = { 15, 16, 15, 17 };
		String[] gender = { "male", "male", "male", "female" };

		String[] addressline1 = { "line1", "line2", "line2", "line4" };
		String[] addressline2 = { "line2", "line3", "city4", "line5" };
		String[] city = { "kolkata", "new town", "razarhat", "salt lake" };
		int[] zipcode = { 742189, 264589, 213645, 895647 };
		String[] sectionName = {"class Five","class Six","class Seven","class Eight"};
		// calling addStudent and addStudentAddress method and providing info for
		// kolkata branch
		for (int i = 0; i < firstName.length; i++) {
			s.addStudents("Kolkata",sectionName[i], firstName[i], lastName[i], age[i], gender[i]);
			s.addStudentAddrres("Kolkata",sectionName[i], addressline1[i], addressline2[i], city[i], zipcode[i]);

		}

		// calling addStudent and addStudentAddress method and providing info for delhi
		// branch
		for (int i = 0; i < firstName.length; i++) {
			s.addStudents("Delhi",sectionName[i], firstName[i], lastName[i], age[i], gender[i]);
			s.addStudentAddrres("Delhi",sectionName[i], addressline1[i], addressline2[i], city[i], zipcode[i]);
		}
		// adding more student in kolkata branch class five section
		s.addStudents("Kolkata","class Five", "rahul", "biswas", 15, "Male");
		s.addStudents("Kolkata","class Five", "rajia", "khatun", 13, "Female");
		
		// adding more student in delhi branch class five section
		s.addStudents("Delhi","class Five", "rahul", "biswas", 15, "Male");
		s.addStudents("Delhi","class Five", "rajia", "khatun", 13, "Female");


		// initialize teacher information
		String[] firstNamet = { "salam", "sumon", "soharab", "neha" };
		String[] lastNamet = { "sk", "mondal", "sk", "roy" };
		int[] aget = { 40, 25, 36, 22 };
		String[] gendert = { "male", "male", "male", "female" };

		String[] addressline1t = { "line1", "line2", "line2", "line4" };
		String[] addressline2t = { "line2", "line3", "city4", "line5" };
		String[] cityt = { "kolkata", "new town", "razarhat", "salt lake" };
		int[] zipcodet = { 742189, 264589, 213645, 895647 };

		String[] subjectst = { "Chemistry CHEM", "Bangla BNG", "Mathematics MATH", "Computer COMP" };
		String[] degreest = { "B.Teach", "M.Teach", "B.Sc", "B.Com." };
		//[] standard = { "class 5", "class 6", "class 7", "class 8", };

		// calling addTeacher method provide info for delhi branch
		for (int i = 0; i < firstNamet.length; i++) {
			s.addTeacher( "Delhi",sectionName[i], firstNamet[i], lastNamet[i], aget[i], gendert[i]);
			s.addTeacherAddress("Delhi",sectionName[i], addressline1t[i], addressline2t[i], cityt[i], zipcodet[i]);
			s.addTeacherSubject("Delhi",sectionName[i], subjectst[i]);
			s.addTeacherDegrees("Delhi",sectionName[i], degreest[i]);
		}

		// calling addTeacher method provide info for kolkata branch
		for (int i = 0; i < firstNamet.length; i++) {
			s.addTeacher( "Kolkata",sectionName[i], firstNamet[i], lastNamet[i], aget[i], gendert[i]);
			s.addTeacherAddress("Kolkata",sectionName[i], addressline1t[i], addressline2t[i], cityt[i], zipcodet[i]);
			s.addTeacherSubject("Kolkata",sectionName[i], subjectst[i]);
			s.addTeacherDegrees("Kolkata",sectionName[i], degreest[i]);
		}

		// time tableSlot

		String[] time = { "10:00 to 11:00", "11:00 to 12:00", "12:00 to 1:00", "1:00 to 2:00", "2:00 to 3:00",
				"3:00 to 4:00" };
		//String[] days = {"Monday","Tuesday","Wednesday","Thursday","Firday","Saturday"};
		String[] mondayClassDetails = { "Chemistry , sonali", "Bangla , sojol", "Maths , souvik", "Break-times",
				"English , soharab", "Physics , sumon",

		};
		String[] tuesDayClassDetails = { "Maths , Ravi","Bangla , sojol", "Physics , sayon", "Break-times",
				"Chemistry , sonali", "Bangla , sojol", };
		String[] wednesdayClassDetails = { "English , soharab", "English , Indrajit","Physics , sumon", "Maths , souvik", "Break-times",
				"Chemistry , sonali",  };
		String[] thursdayClassDetails = { "Chemistry , sonali", "Bangla , sojol", "Maths , souvik", "Break-times",
				"English , soharab", "Physics , sumon",

		};
		String[] friDayClassDetails = { "Maths , Ravi", "English , Indrajit", "Bangla , sojol", "Break-times",
				"Chemistry , sonali", "Bangla , sojol", };
		String[] satursdayClassDetails = { "English , soharab", "Physics , sumon", "Maths , souvik", "Break-times",
				"Chemistry , sonali", "Physics , sayon", };
		
		// set time table for kolkata brach
		// here provided time table details  only  for  section class 5

		s.addTimeTable("Kolkata","class Five","Monday", time, mondayClassDetails);
		s.addTimeTable("Kolkata","class Five","Tuesday", time,tuesDayClassDetails);
		s.addTimeTable("Kolkata","class Five","Wednesday", time, wednesdayClassDetails);
		s.addTimeTable("Kolkata","class Five","Thursday", time, thursdayClassDetails);
		s.addTimeTable("Kolkata","class Five","Firday", time, friDayClassDetails);
		s.addTimeTable("Kolkata","class Five","Saturday", time, satursdayClassDetails);
		
		// set time table for delhi branch 
		// here provided time table details  only  section class 5
		s.addTimeTable("Delhi","class Five","Monday", time, mondayClassDetails);
		s.addTimeTable("Delhi","class Five","Tuesday", time,tuesDayClassDetails);
		s.addTimeTable("Delhi","class Five","Wednesday", time, wednesdayClassDetails);
		s.addTimeTable("Delhi","class Five","Thursday", time, thursdayClassDetails);
		s.addTimeTable("Delhi","class Five","Firday", time, friDayClassDetails);
		s.addTimeTable("Delhi","class Five","Saturday", time, satursdayClassDetails);
		
		
		// print all branches
		 s.printAllBranches();
		
		 
		//print founder details
		s.printFounderDetails();
		
		// print subject details
		s.printSubjectDetails();

		
		// to print specific branch details 
		 s.printBranchDetails("Delhi");
		 s.printBranchDetails("Kolkata");
		 
		 //print all students at specific branch
		 s.printAllStudents("Kolkata");
		 
		 //to print specific brach and section time slot, provide branch name,section, day and time 
		 s.printSpecificTimeTableDetails("Kolkata","class Five","Saturday","10:00 to 11:00");
		
		 //print time table details of specific branch and section
		 // as of now, provided only class Five time details
		 s.printTimeTable("Kolkata","class Five");
	

	}

}
