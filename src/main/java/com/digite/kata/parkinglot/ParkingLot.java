package com.digite.kata.parkinglot;

import java.util.ArrayList;
import java.util.Collections;

public class ParkingLot 
{
	private int a_totalSlots = 0;
	public int a_nextSlotNumber = 1;
	ArrayList<Car> carList = new ArrayList<Car>();
	ArrayList<Integer> nonAllocatedSlots =  new ArrayList<Integer>();
	
    public ParkingLot(int a_totalSlots) 
    {
    	this.a_totalSlots = a_totalSlots;
    }
    
    public int getTotalSlots()
    {
    	return this.a_totalSlots;
    }
    
    public int getNextSlotNumber()
    {
    	if (nonAllocatedSlots.size() > 0)
    	{
    		Collections.sort(nonAllocatedSlots);
    		return nonAllocatedSlots.get(0);
    	}
    	else if (a_nextSlotNumber <= a_totalSlots)
    		return a_nextSlotNumber++;
    	else 
    		return 0;
    }
    
    public String addCarsInList(Car c)
    {
    	if (c.getSlotNo() > 0)
    	{
    		carList.add(c);
    		return "Car with Registration number: " + c.getRegistrationNo() + " " + c.getSlotNo() + "added";
    	}
    	else 
    		return "Sorry, parking lot is full";
    }
    
    public ArrayList<Car> getCarList()
    {
    	return carList;
    }
    
    public void leaveCar(Car car)
    {
    	carList.remove(car);
    	addToNonAllocatedSlots(car.getSlotNo());
    }
    
    public void addToNonAllocatedSlots(int a_slotNo)
    {
    	nonAllocatedSlots.add(a_slotNo);
    }
    
    public ArrayList<Integer> getNonAllocatedSlots()
    {
    	return nonAllocatedSlots;
    }
}