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
    
    public ArrayList<Car> getCarByColor(String color)
    {
    	ArrayList<Car> carsBasedOnColors = new ArrayList<Car>(); 
    	for (Car car : carList)
    	{
    		if (car.getColor().equals(color))
    		{
    			carsBasedOnColors.add(car);
    		}
    	}
		return carsBasedOnColors;
    	
    }
    
    public Car getCarByRegistrationNo(String registrationNo) throws Exception
    {
    	Car carbyNo = null; 
    	for (Car car1 : carList)
    	{
    		if (car1.getRegistrationNo().equals(registrationNo))
    		{
    			carbyNo = car1;
    			break;
    		}
    	}
		
    	if (carbyNo == null)
    		throw new Exception("No car found for this Registartion No");
		return carbyNo;
    	
    }
    
    public ArrayList<Integer> getSlotNumberBasedOnColor(String color)
    { 
    	ArrayList<Integer> w_slots = new ArrayList<Integer>();
    	for (Car car1 : carList)
    	{
    		if (car1.getColor().equals(color))
    		{
    			w_slots.add(car1.getSlotNo());
    		}
    	}
		
    	return w_slots;
    }
    
    public int getSlotNumberBasedOnNo(String regNo)
    { 
    	int w_slot = 0;
    	for (Car car1 : carList)
    	{
    		if (car1.getRegistrationNo().equals(regNo))
    		{
    			w_slot = car1.getSlotNo();
    			break;
    		}
    	}
		
    	return w_slot;
    }
}