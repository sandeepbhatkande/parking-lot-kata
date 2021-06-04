package com.digite.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TicketIssuer
{
    private ArrayList<Integer> m_availableList = null;
    private ArrayList<Integer> m_bookedList = null;
    private HashMap<String, HashMap<String,String>> m_colorwiseMap = new HashMap<String, HashMap<String,String>>();
    private HashMap<Integer, Car> m_slotWiseCarInfo = new HashMap<Integer, Car>();


    public TicketIssuer(ParkingLot w_parkingLot)
    {
       if (m_availableList == null)
       {
           m_availableList = new ArrayList<Integer>();
           for (ParkingSlot slot: w_parkingLot.getAllSlotsInfo()) {
               m_availableList.add(slot.getParkingSlotNo());
           }
       }

    }

    private void SortAvailableSlot(ArrayList<ParkingSlot> allSlotsInfo)
    {
       int w_availableSlot = 0;
        for (ParkingSlot slot: allSlotsInfo)
        {
            if(slot.getIsAvailable())
                m_availableList.add(slot.getParkingSlotNo());
            else
                m_bookedList.add(slot.getParkingSlotNo());
        }
     }

    public String getTicket(Car w_car)
    {
        int w_availableSlot = m_availableList.get(0);
        String w_ticket ="Name : "+ w_car.getOwner()+", Parking Slot : "+ m_availableList.get(0) +", Registeration No: "
                + w_car.getRegNo()+", Color: " + w_car.getColor() + "";

        updatelists(w_availableSlot);

        return w_ticket;
    }

    private void updatelists(int w_availableSlot)
    {
        if(m_bookedList == null)
            m_bookedList = new ArrayList<Integer>();
        m_bookedList.add(w_availableSlot);
        m_availableList.remove(0);
        Collections.sort(m_availableList);
    }
}
