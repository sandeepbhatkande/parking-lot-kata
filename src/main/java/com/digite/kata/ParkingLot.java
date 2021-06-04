package com.digite.kata;

import java.util.ArrayList;

public class ParkingLot
{
    private int m_slots;

    ParkingLot(int a_slots)
    {
       this.m_slots = a_slots;
    }

    public int getTotalSlot()
    {
        return m_slots;
    }

}
