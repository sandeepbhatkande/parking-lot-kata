package com.digite.parkinglot;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JTestParkingInfo {

    @Test
    public void testGetRegNosByCarColor() {
        ParkingLot w_parkingLot = new ParkingLot(10);
        ParkingInfo w_ParkingInfo = new ParkingInfo(w_parkingLot);

        w_parkingLot.allocateSlotToParkCar(new Car("MH11221", "White"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11225", "Red"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11222", "White"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11223", "White"));

        ArrayList<String> w_regNoList = new ArrayList<String>();
        w_regNoList.add("MH11221");
        w_regNoList.add("MH11222");
        w_regNoList.add("MH11223");

        assertEquals(w_regNoList.toString(), w_ParkingInfo.getRegNosByCarColor("White").toString());
    }

    @Test
    public void testGetSlotNoByCarRegNo() {
        ParkingLot w_parkingLot1 = new ParkingLot(10);
        ParkingInfo w_ParkingInfo1 = new ParkingInfo(w_parkingLot1);

        w_parkingLot1.allocateSlotToParkCar(new Car("MH11221", "White"));
        w_parkingLot1.allocateSlotToParkCar(new Car("MH11225", "Red"));
        w_parkingLot1.allocateSlotToParkCar(new Car("MH11222", "White"));
        w_parkingLot1.allocateSlotToParkCar(new Car("MH11223", "White"));

        assertEquals(2, w_ParkingInfo1.getSlotNoByCarRegNo("MH11225"));
    }

    @Test
    public void testGetSlotsNoByCarColor() {
        ParkingLot w_parkingLot2 = new ParkingLot(10);
        ParkingInfo w_ParkingInfo2 = new ParkingInfo(w_parkingLot2);

        w_parkingLot2.allocateSlotToParkCar(new Car("MH11221", "White"));
        w_parkingLot2.allocateSlotToParkCar(new Car("MH11225", "Red"));
        w_parkingLot2.allocateSlotToParkCar(new Car("MH11222", "White"));
        w_parkingLot2.allocateSlotToParkCar(new Car("MH11223", "White"));

        ArrayList<Integer> w_regNoList = new ArrayList<Integer>();
        w_regNoList.add(1);
        w_regNoList.add(3);
        w_regNoList.add(4);
        assertEquals(w_regNoList.toString(), w_ParkingInfo2.getSlotsNoByCarColor("White").toString());
    }
}
