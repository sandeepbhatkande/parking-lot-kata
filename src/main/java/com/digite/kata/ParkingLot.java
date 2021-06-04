package com.digite.kata;

public class ParkingLot
{
    private int m_slots;

    ParkingLot(int a_slots)
    {
        if (a_slots < 0)
            a_slots = 0;

        this.m_slots = a_slots;
    }

    public int getTotalSlot()
    {
        return m_slots;
    }

}
