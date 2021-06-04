package com.digite.kata.tracker;

import java.util.ArrayList;

public class ParkingLot 
{
	private int parkingSlot;
	private ArrayList<ParkingSlot> m_parkingSlotList = null;
	
    public ParkingLot(int parkingSlot) 
    {
    	if (parkingSlot < 0)
    		parkingSlot = 0;
        this.parkingSlot = parkingSlot;
    }
    
    public int getParkingSlot() {
        return parkingSlot;
    }
    
    public ArrayList<ParkingSlot> getSlotsInfo() {
    	return m_parkingSlotList;
    }

}
