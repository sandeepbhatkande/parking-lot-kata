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
        
        m_parkingSlotList = new ArrayList<ParkingSlot>();
        for (int i = 0; i < parkingSlot; i++)
        {
        	m_parkingSlotList.add(new ParkingSlot(i,true));
        }
    }
    
    public int getParkingSlot() {
        return parkingSlot;
    }
    
    public ArrayList<ParkingSlot> getSlotsInfo() {
    	return m_parkingSlotList;
    }

}
