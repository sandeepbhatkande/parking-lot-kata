package com.digite.kata.parkinglot;

import java.util.ArrayList;

public class Car
{
   private String registration_no = "";
   private String color = "";
   private int slotNo = 1;
  
   
   
   public Car(String a_registerNo, String a_color, int a_slotNo)
   {
	   registration_no = a_registerNo;
	   color = a_color;
	   slotNo = a_slotNo;
   }
   
   public String getColor() 
   {
	   return color;
   }
   
   public String getRegistrationNo() 
   {
	   return registration_no;
   }
   
   public int getSlotNo() 
   {
	   return slotNo;
   }
   
}