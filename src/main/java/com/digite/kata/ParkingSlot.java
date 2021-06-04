package com.digite.kata;

public class ParkingSlot
{
    private int m_parkingNo;
    private boolean m_isAvailable;

    ParkingSlot(int a_no, boolean a_isAvailable)
    {
        this.m_parkingNo = a_no;
        this.m_isAvailable = a_isAvailable;
    }

    public int getParkingSlotNo()
    {
        return m_parkingNo;
    }

    public boolean getIsAvailable()
    {
        return m_isAvailable;
    }
}
