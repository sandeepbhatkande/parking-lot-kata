package com.digite.kata.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ParkingLot 
{
	private int a_totalSlots = 0;
	public int a_nextSlotNumber = 1;
	ArrayList<Car> carList = new ArrayList<Car>();
	ArrayList<Integer> nonAllocatedSlots =  new ArrayList<Integer>();
	HashMap<Integer, Car> w_carsWithSlot = new HashMap<Integer, Car>();
	
    public ParkingLot(int a_totalSlots) 
    {
    	this.a_totalSlots = a_totalSlots;
    }
    
    public int getTotalSlots()
    {
    	return this.a_totalSlots;
    }
    
    public HashMap<Integer, Car> getParkedCars()
    {
    	return w_carsWithSlot;
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
    
    
    public String addCars(Car car)
    {
    	int w_slotNo = getNextSlotNumber();
    	if (w_slotNo > 0)
    	{
    		w_carsWithSlot.put(w_slotNo, car);
    		return "Car with Registration number: " + car.getRegistrationNo() + " " + w_slotNo + "added";
    	}
    	else 
    		return "Sorry, parking lot is full";

    }
    
    
    
    public ArrayList<Car> getCarList()
    {
    	ArrayList<Car> w_carList = new ArrayList<Car>();
    	for (Integer w_slot : w_carsWithSlot.keySet())
    	{
    		w_carList.add(w_carsWithSlot.get(w_slot));
    	}
    	return w_carList;
    }
    
    public void leaveCar(int slotNo) throws Exception
    {
    	Car car  = w_carsWithSlot.get(slotNo);
    	if (car != null)
    		w_carsWithSlot.remove(slotNo);
    	else 
    		throw new Exception("Slot is already empty");
    	
    	addToNonAllocatedSlots(slotNo);
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
    	for (Integer slot : w_carsWithSlot.keySet())
    	{
    		if (w_carsWithSlot.get(slot).getColor().equals(color))
    		{
    			carsBasedOnColors.add(w_carsWithSlot.get(slot));
    		}
    	}
		return carsBasedOnColors;
    	
    }
    
    public Car getCarByRegistrationNo(String registrationNo) throws Exception
    {
    	Car carbyNo = null; 
    	for (Integer slot : w_carsWithSlot.keySet())
    	{
    		if (w_carsWithSlot.get(slot).getRegistrationNo().equals(registrationNo))
    		{
    			carbyNo = w_carsWithSlot.get(slot);
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
    	for (Integer slot : w_carsWithSlot.keySet())
    	{
    		if (w_carsWithSlot.get(slot).getColor().equals(color))
    		{
    			w_slots.add(slot);
    		}
    	}
		
    	return w_slots;
    }
    
    public int getSlotNumberBasedOnNo(String regNo)
    { 
    	int w_slot = 0;
    	for (Integer slot : w_carsWithSlot.keySet())
    	{
    		if (w_carsWithSlot.get(slot).getRegistrationNo().equals(regNo))
    		{
    			w_slot = slot;
    			break;
    		}
    	}
		
    	return w_slot;
    }
}