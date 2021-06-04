package com.digite.parkinglot;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JTestParkingInfo {

    ParkingLot w_parkingLot = null;
    ParkingInfo w_ParkingInfo = null;

    @Before
    public void setup() {
        w_parkingLot = new ParkingLot(10);
        w_ParkingInfo = new ParkingInfo(w_parkingLot);

        w_parkingLot.allocateSlotToParkCar(new Car("MH11221", "White"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11225", "Red"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11222", "White"));
        w_parkingLot.allocateSlotToParkCar(new Car("MH11223", "White"));
    }

    @Test
    public void testGetRegNosByCarColor() {
        ArrayList<String> w_regNoList = new ArrayList<String>();
        w_regNoList.add("MH11221");
        w_regNoList.add("MH11222");
        w_regNoList.add("MH11223");

        assertEquals(w_regNoList.toString(), w_ParkingInfo.getRegNosByCarColor("White").toString());
    }

}
