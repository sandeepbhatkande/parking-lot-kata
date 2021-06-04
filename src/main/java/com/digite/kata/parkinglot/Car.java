package com.digite.kata.parkinglot;

public class Car
{
   private String registration_no = "";
   private String color = "";
   
   public Car(String a_registerNo, String a_color)
   {
	   registration_no = a_registerNo;
	   color = a_color;
   }
   
   public String getColor() 
   {
	   return color;
   }
   
   public String getRegistrationNo() 
   {
	   return registration_no;
   }
      
}