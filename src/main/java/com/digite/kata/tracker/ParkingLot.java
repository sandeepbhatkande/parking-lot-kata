package com.digite.kata.tracker;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot 
{
	private int m_parkingSlot;
    private HashMap<Integer, Car> m_slotVsCarInfo =  new HashMap<Integer, Car>();
	
    public ParkingLot(int a_parkingSlot) 
    {
    	//replace with Math.max
        this.m_parkingSlot = Math.max(0, a_parkingSlot);
    }
    
    public String getParkingSlot()
    {
        return "Created a parking lot with " + m_parkingSlot + " slots";
    }
    
    public String getAllocatedSlotNo(Car a_car)
    {
    	String w_allocatedSlotNo = null;
    	
    	int w_availableSlot = getNearestParkingPoint(); //m_availableList.get(0);  //replace with smallest no logic
    	
    	if (w_availableSlot != 0 && m_slotVsCarInfo.size() <= m_parkingSlot)
    	{
    		m_slotVsCarInfo.put(w_availableSlot, a_car);
    		w_allocatedSlotNo = "Allocated slot number: " + w_availableSlot;
    	}
    	else
    		w_allocatedSlotNo = "Sorry, parking lot is full";

        return w_allocatedSlotNo;
    }
    

    private int getNearestParkingPoint() 
    {
    	int w_emptySlot = 0;
    	for(int i=1; i <= m_parkingSlot; i++)
    	{
    		Car w_car = m_slotVsCarInfo.get(i);
    		if (w_car == null)
    		{
    			w_emptySlot = i;
    			break;
    		}	
    	}
    	return w_emptySlot;
	}
    
    public String leaveCar(int a_slotNo)
    {
    	m_slotVsCarInfo.remove(a_slotNo);
    	return "Slot number " + a_slotNo + " is free";
    }
    
	public String getStatus()
	{
		String w_status = "";
		int w_counter = 1;
		for(Integer slotNo: m_slotVsCarInfo.keySet())
		{
			w_status+= + w_counter + ".Slot No: " + slotNo + ",Registeration No: " + m_slotVsCarInfo.get(slotNo).getRegNo() +
						",Color: " + m_slotVsCarInfo.get(slotNo).getColor()+ "\n";
			w_counter++;
		}
		
		return w_status;
		
	}

	public ArrayList<String> getRegisterationNosDependingOnColor(String a_color) 
	{
		ArrayList<String> w_filteredRegisterationNos = new ArrayList<String>();
		for(Integer slotNo: m_slotVsCarInfo.keySet())
		{
			if(m_slotVsCarInfo.get(slotNo).getColor().equalsIgnoreCase(a_color))
			{
				w_filteredRegisterationNos.add(m_slotVsCarInfo.get(slotNo).getRegNo());
			}
		}
		return w_filteredRegisterationNos;
	}

	public ArrayList<String> getSlotNoDependingOnColor(String a_color) 
	{
		ArrayList<String> w_filteredSlotNos = new ArrayList<String>();
		for(Integer slotNo: m_slotVsCarInfo.keySet())
		{
			if(m_slotVsCarInfo.get(slotNo).getColor().equalsIgnoreCase(a_color))
			{
				w_filteredSlotNos.add(String.valueOf(slotNo));
			}
		}
		return w_filteredSlotNos;
	}

	public String getSlotNoForRegisterationNo(String a_registerationNo) 
	{
		String w_slotNo = null;
		for(Integer slotNo: m_slotVsCarInfo.keySet())
		{
			if(m_slotVsCarInfo.get(slotNo).getRegNo().equalsIgnoreCase(a_registerationNo))
				w_slotNo = String.valueOf(slotNo);
		}
		if (w_slotNo == null)
			return "Not Found";
		
		return w_slotNo;
	}
}
