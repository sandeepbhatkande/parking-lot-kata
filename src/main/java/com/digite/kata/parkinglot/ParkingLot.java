package com.digite.kata.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
	private int maxParkingCapacity;
	private HashMap<Long, Car> slots;
	
	public ParkingLot(int maxParkingCapacity) {
		this.maxParkingCapacity = maxParkingCapacity;
		slots = new HashMap<Long, Car>();
    }

	public HashMap<Long, Car> getSlots() 
	{
		return slots;
	}
	
    public int getMaxParkingCapacity() {
        return maxParkingCapacity;
    }
    
    public void setMaxParkingCapacity(int maxParkingCapacity) {
        this.maxParkingCapacity = maxParkingCapacity;
    }
    
    public String issueParkingSlot(String registrationNunber, String color) 
    {
    	String msg = "";
    	Car car = new Car(registrationNunber, color);
    	int nearestSlot = getNearestSlot();
    	if(nearestSlot > 0) {
    		getSlots().put(Long.valueOf(nearestSlot), car);
    		msg = "Slot allocated successfully";
    	}
    	else {
    		msg = "No Slot available";
    	}
    	return msg;
    }
    
    public int getNearestSlot() 
    {
    	int nearestSlot = 0;
    	for(int i = 1; i <= getMaxParkingCapacity(); i++) 
    	{
    		if(!getSlots().containsKey(Long.valueOf(i))) 
    		{
    			nearestSlot = i;
    			break;
    		}
    	}
    	return nearestSlot;
    }

	public String leaveParkingSlot(Long slotNumber) 
	{
		getSlots().remove(slotNumber);
		return "Leave Parking Slot successful";
	}

	public Long findSlotNumberByRegNumber(String registrationNumber) 
	{
		Long slotNumber =  0L;
		for(Long slot: getSlots().keySet())
		{
			if(registrationNumber.equals(getSlots().get(slot).getRegistrationNumber())) 
			{
				slotNumber = slot;
				break;
			}
		}
		
		return slotNumber;
	}

	public List<Long> findSlotsByCarColor(String color) 
	{
		List<Long> slotList =  new ArrayList<Long>();
		for(Long slot: getSlots().keySet())
		{
			if(color.equals(getSlots().get(slot).getColor())) 
			{
				slotList.add(slot);
			}
		}
		
		return slotList;
	}
	
	public List<String> findRegNumberByCarColor(String color) 
	{
		List<String> regNumList =  new ArrayList<String>();
		for(Long slot: getSlots().keySet())
		{
			Car car = getSlots().get(slot);
			if(color.equals(car.getColor())) 
			{
				regNumList.add(car.getRegistrationNumber());
			}
		}
		
		return regNumList;
	}
}
