package com.digite.kata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ParkingLot
{
    private int m_slots;
    private ArrayList<Integer> m_availableList = null;
    private ArrayList<Integer> m_bookedList = null;
    private HashMap<Integer, Car> m_slotWiseCarInfo = null;
    private HashMap<String, Car> m_colorWiseCarInfo = null;

    ParkingLot(int a_slots)
    {
        if (a_slots < 0)
            a_slots = 0;

        this.m_slots = a_slots;
        intializeLists();
    }

    private void intializeLists()
    {
        m_availableList = new ArrayList<Integer>();
        for(int i=1 ; i <= this.m_slots; i++)
        {
            m_availableList.add(i);
        }
        m_bookedList = new ArrayList<Integer>();
        m_slotWiseCarInfo = new HashMap<Integer, Car>();
        m_colorWiseCarInfo = new HashMap<String, Car>();
    }

    public int getTotalSlot()
    {
        return m_slots;
    }

    public ArrayList<Integer> getAvailableSlotList()
    {
        return m_availableList;
    }

    public ArrayList<Integer> getBookedSlotList()
    {
        return m_bookedList;
    }

    public String park(Car w_car)
    {
        String w_ticket = "";
        int w_slot = m_availableList.size() > 0 ? m_availableList.get(0) : 0;
        if (w_slot > 0) {
            m_bookedList.add(w_slot);
            m_availableList.remove(0);
            w_ticket = "Name : " + w_car.getOwner() + ", Parking Slot : " + w_slot + ", Registeration No: "
                    + w_car.getRegNo() + ", Color: " + w_car.getColor() + "";

        } else
            w_ticket = "No Slots Available";


        return  w_ticket;

    }

    public void Leave(Car w_car)
    {

    }

    public HashMap<Integer, Car> getSLotWiseCarMap()
    {
        return m_slotWiseCarInfo;
    }

    public HashMap<String, Car> getColorWiseCarMap()
    {
        return  m_colorWiseCarInfo;
    }
}
