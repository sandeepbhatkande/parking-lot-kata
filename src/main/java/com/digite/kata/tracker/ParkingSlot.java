package com.digite.kata.tracker;

public class ParkingSlot 
{
	private int parkingSlotNo;
	private boolean isAvailable;

    public ParkingSlot(int parkingSlotN0, boolean isAvailable) 
    {
        this.parkingSlotNo = parkingSlotN0;
        this.isAvailable = isAvailable;
    }
    
    public int getParkingSlotNo() {
        return parkingSlotNo;
    }
    
    public boolean isAvailable() {
    	return isAvailable;
    }
}
