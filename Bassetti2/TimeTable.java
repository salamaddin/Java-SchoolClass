package com.bassetti.Bassetti2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TimeTable {
	//String subject, day, time;
	LinkedHashMap<String, HashMap<String, String>> slot ;
	
	TimeTable(){
		//timeTableSlot();
		slot = new LinkedHashMap();
	}
	
	public void addTimeTable(String day, String time[], String classDetails[]) {
		HashMap<String, String> temp = new HashMap<String, String> ();
			
			for (int i = 0; i < time.length; i++) {
				temp.put(time[i], classDetails[i]);
			}
		
		slot.put(day, temp);
	}
	
	
	public void getSlotDetails(String day, String time) {
//		timeTableSlot();
		System.out.println(day+" "+time+ " "+slot.get(day).get(time)); 
	}
	
	public void printTimeTable() {
		System.out.println("---------------------Time Table---------------------");
		for (String day : slot.keySet()) {
			System.out.print(day+" ");
			//System.out.println(slot.get("Saturday").get("10:00 to 11:00"));
			System.out.println(slot.get(day)); 
		}
		
		//System.out.println(slot.get("Monday")); 
	}
	
}
