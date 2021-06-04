package com.digite.parkinglot;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JTestParkingLot {
    ParkingLot w_parkingLot = null;

    @Before
    public void setup() {
        w_parkingLot = new ParkingLot(10);
    }

    @Test
    public void testGetParkingSlot() {
        assertEquals(10, w_parkingLot.getSlots());
    }

    @Test
    public void testAllocateSlotToParkCar_success() {
        Car w_car = new Car("MH11222", "White");
        assertEquals("Allocated slot 1 to MH11222", w_parkingLot.allocateSlotToParkCar(w_car));
    }

    @Test
    public void testAllocateSlotToParkCar_allocationFailed() {
        Car w_car = new Car("MH11222", "White");
        String w_carRegNo[] = {"MH11221", "MH11222", "MH11223", "MH11224", "MH11225", "MH11226", "MH11227", "MH11228","MH11229", "MH11210"};
        for (int i = 0; i < w_carRegNo.length; i++) {
            w_car = new Car(w_carRegNo[i], "White");
            w_parkingLot.allocateSlotToParkCar(w_car);
        }
        w_car = new Car("MH11211", "White");
        assertEquals("All slots are booked", w_parkingLot.allocateSlotToParkCar(w_car));
    }

    @Test
    public void testDeAllocateSlotOfParkedCar_success() {
        assertEquals("Slot 1 is available for parking", w_parkingLot.deAllocateSlot("MH11222"));
    }

    @Test
    public void testDeAllocateSlotOfParkedCar_deallocationFailed() {
        assertEquals("Car is not parked", w_parkingLot.deAllocateSlot("MH34567222"));
    }

}
