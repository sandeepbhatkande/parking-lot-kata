package com.digite.kata;

import java.util.ArrayList;

public class ParkingLot
{
 	private int _parkingSlot;
 	int _NextSlotNumber = 0;
 	private ArrayList<Car> _carList = new ArrayList<Car>();
 	
    public ParkingLot(int w_slotCount) {
    	_parkingSlot = w_slotCount;
    }
    
    public int getparkingSlotCount(){
    	return _parkingSlot;
    }
    
    public int getNextSlotNumber()
    {
    	if(_NextSlotNumber < _parkingSlot)
    		return ++_NextSlotNumber;
    	else
    		return 0;
    }
    
    public String addCarInList(Car w_car)
	 {
    	if(w_car.getslotNumber() > 0)
    	{
    		_carList.add(w_car);
    		System.out.println("Allocated slot number:"+ _NextSlotNumber);
    		return "Allocated slot number:"+ _NextSlotNumber;
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
}