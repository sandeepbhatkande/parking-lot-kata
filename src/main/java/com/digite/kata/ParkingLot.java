package com.digite.kata;

import java.util.ArrayList;
import java.util.Collections;

public class ParkingLot
{
    private int m_slots;
    private ArrayList<Integer> m_availableList = null;
    private ArrayList<Integer> m_bookedList = null;

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

    public void park(Car w_car)
    {
       int w_slot = m_availableList.size() > 0 ? m_availableList.get(0) : 0;
       if(w_slot > 0)
       {
           m_bookedList.add(w_slot);
           m_availableList.remove(w_slot-1);
       }


    }

}
