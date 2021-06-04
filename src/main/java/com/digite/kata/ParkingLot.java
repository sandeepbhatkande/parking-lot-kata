package com.digite.kata;

import java.util.ArrayList;

public class ParkingLot
{
    private int m_slots;
    private ArrayList<ParkingSlot> m_slotList = null;

    ParkingLot(int a_slots)
    {
        if (a_slots < 0)
            a_slots = 0;

        this.m_slots = a_slots;
        initializeList();
    }

    private void initializeList()
    {
        m_slotList = new ArrayList<ParkingSlot>();
        for (int i = 1; i <= this.m_slots; i++)
        {
            m_slotList.add(new ParkingSlot(i,true));
        }
    }

    public int getTotalSlot()
    {
        return m_slots;
    }

    public ArrayList<ParkingSlot> getAllSlotsInfo()
    {
        return m_slotList;
    }

}
