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
    private HashMap<String, ArrayList<String>> m_colorWiseCarInfo = null;

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
        m_colorWiseCarInfo = new HashMap<String, ArrayList<String>>();
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


            updateMap(w_slot, w_car);

        } else
            w_ticket = "No Slots Available";


        return  w_ticket;

    }

    private void updateMap(int w_slot, Car w_car)
    {
        m_slotWiseCarInfo.put(w_slot, w_car);
        String w_color = w_car.getColor();
        ArrayList<String> w_list = new ArrayList<String>();
        if(m_colorWiseCarInfo.containsKey(w_color))
        {
            w_list = m_colorWiseCarInfo.get(w_color);
            w_list.add(w_car.getRegNo());
        }
        else
            w_list.add(w_car.getRegNo());

        m_colorWiseCarInfo.put(w_car.getColor(), w_list);

    }

    public void Leave(Car w_car)
    {
        int w_slotToEmpty = getSlotNumberByRegisterationNo(w_car.getRegNo());
        for(int w_slot : m_slotWiseCarInfo.keySet())
        {
            if(m_slotWiseCarInfo.get(w_slot).getRegNo().equals(w_car.getRegNo()))
            {
                w_slotToEmpty = w_slot;
                break;
            }
        }

        if(w_slotToEmpty > 0)
        {
            //remove from bookedlists and addtoAvailableList
            int index = 0;
            for(int w_slot : m_bookedList)
            {
                if(w_slot == w_slotToEmpty)
                {
                   m_bookedList.remove(index);
                   m_availableList.add(w_slotToEmpty);
                   break;
                }
                index++;
            }

            //remove from maps
            m_slotWiseCarInfo.remove(w_slotToEmpty);
            index = 0;
            ArrayList<String> list = getCarListOfSameColor(w_car.getColor());
            for(String w_regNo : list)
            {
                if(w_regNo.equals(w_car.getRegNo()))
                {
                    break;
                }
                index++;
            }
            list.remove(index);
            m_colorWiseCarInfo.put(w_car.getColor(), list);
        }

        Collections.sort(m_availableList);
    }

    public HashMap<Integer, Car> getSLotWiseCarMap()
    {
        return m_slotWiseCarInfo;
    }

    public HashMap<String, ArrayList<String>> getColorWiseCarMap()
    {
        return  m_colorWiseCarInfo;
    }

    public int getSlotNumberByRegisterationNo(String a_regNo)
    {
        int w_slotNo = 0;
        for(int w_slot : m_slotWiseCarInfo.keySet())
        {
            if(a_regNo.equals(m_slotWiseCarInfo.get(w_slot).getRegNo()))
            {
                w_slotNo = w_slot;
            }
        }
        return w_slotNo;

    }

    public ArrayList<String> getCarListOfSameColor(String a_color)
    {
        ArrayList<String> w_list = new ArrayList<String>();
        if(m_colorWiseCarInfo.containsKey(a_color))
            w_list = m_colorWiseCarInfo.get(a_color);

        return w_list;
    }

    public ArrayList<Integer> getSlotListOfSameColor(String a_color)
    {
        ArrayList<Integer> w_list = new ArrayList<Integer>();
        for (int slot: m_slotWiseCarInfo.keySet())
        {
            if(a_color.equals(m_slotWiseCarInfo.get(slot).getColor()))
                w_list.add(slot);
        }

        return w_list;
    }

    public String getCurrentStatus()
    {
        String w_status = "SlotNo|CarNo|CarColor|CarOwner|" + "\n";

        for (int i = 1; i <= this.m_slots ; i++)
        {
           if(m_slotWiseCarInfo.containsKey(i))
           {
               Car w_car = m_slotWiseCarInfo.get(i);
               w_status +=   i + "|" + w_car.getRegNo() + "|" + w_car.getColor() + "|" + w_car.getOwner() + "|" + "\n";
           }
           else
               w_status += "-|-|-|-|";
        }


        return w_status;
    }
}
