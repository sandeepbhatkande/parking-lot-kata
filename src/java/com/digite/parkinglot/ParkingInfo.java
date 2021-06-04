package com.digite.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingInfo {
    ParkingLot parkingLot = null;
    public ParkingInfo(ParkingLot w_parkingLot1) {
        this.parkingLot = w_parkingLot1;
    }

    public ArrayList<String> getRegNosByCarColor(String color) {
        ArrayList<String> w_regNoList = new ArrayList<String>();
        HashMap<Integer, Car> w_slotAllocationMap = parkingLot.getSlotAllocationMap();

        for (Integer slot: w_slotAllocationMap.keySet())
        {
            Car car = w_slotAllocationMap.get(slot);

            if (color == car.getCOLOR()) {
                w_regNoList.add(car.getREG_NO());
            }
        }
        return w_regNoList;
    }

}
