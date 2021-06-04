package com.digite.kata;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketIssuer
{
    private ArrayList<Integer> m_availableList = new ArrayList<Integer>();
    private ArrayList<Integer> m_bookedList = new ArrayList<Integer>();
    private HashMap<String, HashMap<String,String>> m_colorwiseMap = new HashMap<String, HashMap<String,String>>();
    private HashMap<Integer, Car> m_slotWiseCarInfo = new HashMap<Integer, Car>();


    public TicketIssuer(Car w_car, ParkingLot w_parkingLot)
    {

    }

    public String getTicket()
    {
        return null;
    }
}
