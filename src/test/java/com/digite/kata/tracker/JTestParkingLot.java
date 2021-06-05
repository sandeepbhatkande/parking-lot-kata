package com.digite.kata.tracker;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JTestParkingLot 
{
	@Test
	public void parkingLotCreated()
	{
		ParkingLot w_parkingLot = new ParkingLot(6);
		Assertions.assertEquals("Created a parking lot with 6 slots", w_parkingLot.getParkingSlot());	
	}
	
	@Test
    public void testGetAllocatedSlotNo()
    {
        ParkingLot w_parkingLot = new ParkingLot(10);
        
        Car w_car = new Car("White", "MH-03-9000", "Hitesh Narwani");
        String w_allocatedNo = "Allocated slot number: 1";
        Assertions.assertEquals(w_allocatedNo, w_parkingLot.getAllocatedSlotNo(w_car));
        
        Car w_car1 = new Car("White", "MH-03-9001", "Sandeep Bhatkande");
        String w_allocatedNo1 = "Allocated slot number: 2";
        Assertions.assertEquals(w_allocatedNo1, w_parkingLot.getAllocatedSlotNo(w_car1));

    }
    
    @Test 
	public void testExceedsParkingLimit() 
	{
		 ParkingLot w_parkingLot = new ParkingLot(3);
		  
		 Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	     Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	        
	     Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	        
	     Car w_car3 = new Car("White", "MH-03-9003", "Amey Patil");
	     Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
		     	
		 Car w_car4 = new Car("Black", "MH-03-9004", "Seema Ubhare");
		 Assertions.assertEquals("Sorry, parking lot is full", w_parkingLot.getAllocatedSlotNo(w_car4));
			 
	 }
    
     @Test
     public void testLeaveCar()
     {
		 ParkingLot w_parkingLot = new ParkingLot(5);
		
		 Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	     Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	    
	     Car w_car2 = new Car("White", "MH-03-9002", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	    
	     Car w_car3 = new Car("White", "MH-03-9003", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
	   
	     String w_freedSlotNo = w_parkingLot.leaveCar(2);
	     Assertions.assertEquals("Slot number 2 is free", w_freedSlotNo);
          	
     }
    
    @Test
    public void testLeaveCarAndAllocateAnother()
    {
    	ParkingLot w_parkingLot = new ParkingLot(5);
    	
        Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
        Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
        
        Car w_car2 = new Car("White", "MH-03-9002", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
        
        Car w_car3 = new Car("White", "MH-03-9003", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
       
        String w_freedSlotNo = w_parkingLot.leaveCar(2);
        Assertions.assertEquals("Slot number 2 is free", w_freedSlotNo);
        
        Car w_car4 = new Car("White", "MH-03-9004", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car4));
        
        Car w_car5 = new Car("White", "MH-03-9005", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 4", w_parkingLot.getAllocatedSlotNo(w_car5));
          	
    }
    
    @Test 
	public void testGetRegisterationNosDependingOnColor() 
	{
	    ParkingLot w_parkingLot = new ParkingLot(10);
	  
	    Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	    Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	    
	    Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	    Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	    
	    Car w_car3 = new Car("White", "MH-03-9003", "Sakshe Goga");
	    Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
	       
	    Car w_car4 = new Car("Black", "MH-03-9004", "Amey Patil");
	    Assertions.assertEquals("Allocated slot number: 4", w_parkingLot.getAllocatedSlotNo(w_car4));
	  
	    Car w_car5 = new Car("Black", "MH-03-9005", "Jishan Shaikh");
	    Assertions.assertEquals("Allocated slot number: 5", w_parkingLot.getAllocatedSlotNo(w_car5));
	    
	    ArrayList<String> w_expectedRegistertionNoList = new ArrayList<String>();
	    w_expectedRegistertionNoList.add("MH-03-9000");
	    w_expectedRegistertionNoList.add("MH-03-9003");
	    
	    ArrayList<String> w_registerationNosList = w_parkingLot.getRegisterationNosDependingOnColor("White");
	    Assertions.assertEquals(w_expectedRegistertionNoList, w_registerationNosList);
 
	}
    
    @Test 
	public void testGetSlotNoDependingOnColor() 
	{
	    ParkingLot w_parkingLot = new ParkingLot(10);
	  
	    Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	    Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	    
	    Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	    Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	    
	    Car w_car3 = new Car("White", "MH-03-9003", "Sakshe Goga");
	    Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
	       
	    Car w_car4 = new Car("Black", "MH-03-9004", "Amey Patil");
	    Assertions.assertEquals("Allocated slot number: 4", w_parkingLot.getAllocatedSlotNo(w_car4));
	  
	    Car w_car5 = new Car("Black", "MH-03-9005", "Jishan Shaikh");
	    Assertions.assertEquals("Allocated slot number: 5", w_parkingLot.getAllocatedSlotNo(w_car5));
	    
	    ArrayList<String> w_expectedSlotNoList = new ArrayList<String>();
	    w_expectedSlotNoList.add("4");
	    w_expectedSlotNoList.add("5");
	    
	    ArrayList<String> w_slotNosList = w_parkingLot.getSlotNoDependingOnColor("Black");
	    Assertions.assertEquals(w_expectedSlotNoList, w_slotNosList);
 
	}
    
    @Test 
	public void testGetSlotNoForRegisterationNo() 
	{
	    ParkingLot w_parkingLot = new ParkingLot(10);
	  
	    Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	    Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	    
	    Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	    Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	    
	    Car w_car3 = new Car("White", "MH-03-9003", "Sakshe Goga");
	    Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
	       
	    Car w_car4 = new Car("Black", "MH-03-9004", "Amey Patil");
	    Assertions.assertEquals("Allocated slot number: 4", w_parkingLot.getAllocatedSlotNo(w_car4));
	  
	    Car w_car5 = new Car("Black", "MH-03-9005", "Jishan Shaikh");
	    Assertions.assertEquals("Allocated slot number: 5", w_parkingLot.getAllocatedSlotNo(w_car5));
	    
	    String w_slotNo = w_parkingLot.getSlotNoForRegisterationNo("MH-03-9004");
	    Assertions.assertEquals("4", w_slotNo);
	    
	    String w_slotNo1 = w_parkingLot.getSlotNoForRegisterationNo("MH-03-9006");
	    Assertions.assertEquals("Not Found", w_slotNo1);
 
	}
    
    @Test
    public void getStatus()
    {
    	ParkingLot w_parkingLot = new ParkingLot(10);
	  
	    Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	    Assertions.assertEquals("Allocated slot number: 1", w_parkingLot.getAllocatedSlotNo(w_car1));
	    
	    Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	    Assertions.assertEquals("Allocated slot number: 2", w_parkingLot.getAllocatedSlotNo(w_car2));
	    
	    Car w_car3 = new Car("White", "MH-03-9003", "Sakshe Goga");
	    Assertions.assertEquals("Allocated slot number: 3", w_parkingLot.getAllocatedSlotNo(w_car3));
	       
	    Car w_car4 = new Car("Black", "MH-03-9004", "Amey Patil");
	    Assertions.assertEquals("Allocated slot number: 4", w_parkingLot.getAllocatedSlotNo(w_car4));
	  
	    Car w_car5 = new Car("Black", "MH-03-9005", "Jishan Shaikh");
	    Assertions.assertEquals("Allocated slot number: 5", w_parkingLot.getAllocatedSlotNo(w_car5));
	    
	    String w_expectedstatus = "1.Slot No: 1,Registeration No: MH-03-9000,Color: White\n"
	    				  + "2.Slot No: 2,Registeration No: MH-03-9002,Color: Red\n"
	    				  + "3.Slot No: 3,Registeration No: MH-03-9003,Color: White\n"
	    				  + "4.Slot No: 4,Registeration No: MH-03-9004,Color: Black\n"
	    				  + "5.Slot No: 5,Registeration No: MH-03-9005,Color: Black\n";
	    
	    String w_actualStatus =  w_parkingLot.getStatus();
	    Assertions.assertEquals(w_expectedstatus, w_actualStatus);
    }
	
}
