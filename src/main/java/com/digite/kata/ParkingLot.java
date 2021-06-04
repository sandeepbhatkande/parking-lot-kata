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
    	if(_NextSlotNumber <= _parkingSlot)
    		return ++_NextSlotNumber;
    	else
    		return 0;
    }
    
    public String addCarInList(Car w_car)
	 {
		 _carList.add(w_car);
		 System.out.println("Allocated slot number:"+ _NextSlotNumber);
		 return "Allocated slot number:"+ _NextSlotNumber;
	 }
	 
	 public ArrayList<Car> getCarList()
	 {
		 return _carList;
	 }
}