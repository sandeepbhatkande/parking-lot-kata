package com.digite.kata.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TicketIssuer
{
    private ArrayList<Integer> m_availableList = null;
    private ArrayList<Integer> m_bookedList = null;

    public TicketIssuer(ParkingLot w_parkingLot)
    {
       if (m_availableList == null)
       {
           m_availableList = new ArrayList<Integer>();
           for (ParkingSlot slot: w_parkingLot.getSlotsInfo()) {
               m_availableList.add(slot.getParkingSlotNo());
           }
       }

    }

    public String getTicket(Car w_car)
    {
        int w_availableSlot = m_availableList.get(0);
        String w_ticket ="Name : "+ w_car.getOwnerName()+", Parking Slot : "+ m_availableList.get(0) +", Registeration No: "
                + w_car.getRegNo()+", Color: " + w_car.getColor() + "";

        updatelists(w_availableSlot);

        return w_ticket;
    }

    private void updatelists(int w_availableSlot)
    {
        if(m_bookedList == null)
            m_bookedList = new ArrayList<Integer>();
        m_bookedList.add(w_availableSlot);
        m_availableList.remove(w_availableSlot);
        Collections.sort(m_availableList);
    }
}