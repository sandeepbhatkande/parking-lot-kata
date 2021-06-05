package com.digite.kata.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ParkingLot 
{
	private int m_parkingSlot;
	private ArrayList<Integer> m_availableList = null;
    private ArrayList<Integer> m_bookedList = null;
    private HashMap<Integer, Car> m_slotVsCarInfo =  new HashMap<Integer, Car>();
	
    public ParkingLot(int a_parkingSlot) 
    {
    	//replace with Math.max
        this.m_parkingSlot = Math.max(0, a_parkingSlot);
        
        if (m_availableList == null)
        {
            m_availableList = new ArrayList<Integer>();
            for (int i = 1; i <= m_parkingSlot; i++)
            {
            	m_availableList.add(i);
            }
        }

    }
    
    public String getParkingSlot()
    {
        return "Created a parking lot with " + m_parkingSlot + " slots";
    }
    
    public String getAllocatedSlotNo(Car a_car)
    {
    	if (m_availableList.isEmpty())
    		return "Sorry, parking lot is full";
    	
        int w_availableSlot = m_availableList.get(0);  //replace with smallest no logic
        String w_AllocatedSlotNo = "Allocated slot number: " + w_availableSlot;
        updatelists(w_availableSlot);
        m_slotVsCarInfo.put(w_availableSlot, a_car);

        return w_AllocatedSlotNo;
    }
    

    private void updatelists(int w_availableSlot)
    {
        if(m_bookedList == null)
            m_bookedList = new ArrayList<Integer>();
        m_bookedList.add(w_availableSlot);
        m_availableList.remove(0);
        Collections.sort(m_availableList);
    }
    
    public String leaveCar(int a_slotNo)
    {
    	m_slotVsCarInfo.remove(a_slotNo);
    	m_bookedList.remove(m_bookedList.indexOf(a_slotNo));
    	m_availableList.add(a_slotNo);
    	Collections.sort(m_availableList);
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
