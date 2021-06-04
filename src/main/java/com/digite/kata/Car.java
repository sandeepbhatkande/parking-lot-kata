package com.digite.kata;

import java.util.ArrayList;

public class Car 
{
	private String _RegiNumber;
	private String _color;
	private int _slotNumber;
	
	
	 public Car(String a_RegiNumber, String a_color, int a_slotNumber) {
		 _RegiNumber = a_RegiNumber;
		 _color = a_color;
		 _slotNumber = a_slotNumber;
	}

	 public String getRegiNumber()
	 {
		 return _RegiNumber; 
	 }
	 
	 public String getcolor()
	 {
		 return _color; 
	 }
	 
	 public int getslotNumber()
	 {
		 return _slotNumber; 
	 }
	 
	
	 
}
