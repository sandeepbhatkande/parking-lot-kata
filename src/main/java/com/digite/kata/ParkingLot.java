package com.digite.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class ParkingLot
{
 	private int _parkingSlot;
 	int _NextSlotNumber = 0;
 	private ArrayList<Car> _carList = new ArrayList<Car>();
 	private ArrayList<Integer> _removeCarSlotID = new ArrayList<Integer>();
 	
    public ParkingLot(int w_slotCount) {
    	_parkingSlot = w_slotCount;
    }
    
    public int getparkingSlotCount(){
    	return _parkingSlot;
    }
    
    public int getNextSlotNumber()
    {
    	if(!_removeCarSlotID.isEmpty())
		{
    		Collections.sort(_removeCarSlotID);
    		int slot = _removeCarSlotID.get(0);
    		_removeCarSlotID.remove(0);
    		return slot;
		}
    	else if(_NextSlotNumber < _parkingSlot)
    		return ++_NextSlotNumber;
    	else
    		return 0;
    }
    
    public String addCarInList(Car w_car)
	 {
    	if(w_car.getslotNumber() > 0)
    	{
    		_carList.add(w_car);
    		System.out.println("Allocated slot number:"+ w_car.getslotNumber());
    		return "Allocated slot number:"+ w_car.getslotNumber();
    	}
    	else
    	{
    		System.out.println("Sorry, parking lot is full");
    		return "Sorry, parking lot is full";
    	}
	 }
	 
	 public ArrayList<Car> getCarList()
	 {
		 return _carList;
	 }
	 
	 public String RemoveCar(Car a_car){
		 
		 String err = "Slot number "+ a_car.getslotNumber() + " is free";
		 _removeCarSlotID.add(a_car.getslotNumber());
		 _carList.remove(a_car);
		 System.out.println(err);
		 return err;
	 }
	 
	 public  ArrayList<Car> getFilterCarList(String Type, String value)
	 {
		 ArrayList<Car> w_filteredCarList = null;
		 if(Type.equals("color"))
		 {
	    	w_filteredCarList = (ArrayList<Car>) _carList.stream()
	        	    .filter(obj -> obj.getcolor() == value).collect(Collectors.toList());
		 }
		 if(Type.equals("slot"))
		 {
			 w_filteredCarList = (ArrayList<Car>) _carList.stream()
		        	    .filter(obj -> obj.getslotNumber() == Integer.parseInt(value)).collect(Collectors.toList()); 
		 }
		 else if (Type.equals("regNum"))
		 {
			 w_filteredCarList = (ArrayList<Car>) _carList.stream()
		        	    .filter(obj -> obj.getcolor() == value).collect(Collectors.toList());
		 }
		 
		 return w_filteredCarList; 
	 }
}