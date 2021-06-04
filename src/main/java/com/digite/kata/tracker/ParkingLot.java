package com.digite.kata.tracker;

public class ParkingLot 
{
	private int parkingSlot;

    public ParkingLot(int parkingSlot) 
    {
    	if (parkingSlot < 0)
    		parkingSlot = 0;
        this.parkingSlot = parkingSlot;
    }
    
    public int getParkingSlot() {
        return parkingSlot;
    }

}
