package com.digite.parkinglot;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JTestParkingLot {

    @Test
    public void testGetParkingSlot() {
        ParkingLot w_parkingLot = new ParkingLot(10);
        assertEquals(10, w_parkingLot.getSlots());
    }

    @Test
    public void testAllocateSlotToParkCar_success() {
        ParkingLot w_parkingLot = new ParkingLot(10);
        Car w_car = new Car("MH11222", "White");
        assertEquals("Allocated slot 1 to MH11222", w_parkingLot.allocateSlotToParkCar(w_car));
    }

    @Test
    public void testAllocateSlotToParkCar_allocationFailed() {
        ParkingLot w_parkingLot = new ParkingLot(10);
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
        ParkingLot w_parkingLotForDeallocate1 = new ParkingLot(10);
        Car w_car = new Car("MH11211", "White");
        w_parkingLotForDeallocate1.allocateSlotToParkCar(w_car);
        assertEquals("Slot 1 is available for parking", w_parkingLotForDeallocate1.deAllocateSlot(1));
    }

    @Test
    public void testDeAllocateSlotOfParkedCar_deallocationFailed() {
        ParkingLot w_parkingLotForDeallocate2 = new ParkingLot(10);
        Car w_car = new Car("MH11211", "White");
        w_parkingLotForDeallocate2.allocateSlotToParkCar(w_car);
        assertEquals("Slot is already empty", w_parkingLotForDeallocate2.deAllocateSlot(2));
    }

    @Test
    public void testDeAllocateSlotOfParkedCar_deallocateAndReallocateSameSlot() {
        ParkingLot w_parkingLotForDeallocate3 = new ParkingLot(10);
        Car w_car = new Car("MH11211", "White");
        w_parkingLotForDeallocate3.allocateSlotToParkCar(w_car);
        assertEquals("Slot 1 is available for parking", w_parkingLotForDeallocate3.deAllocateSlot(1));
        //Allocate same slot
        assertEquals("Allocated slot 1 to MH11211", w_parkingLotForDeallocate3.allocateSlotToParkCar(w_car));
    }

    @Test
    public void testGetStatus() {
        ParkingLot w_parkingLot4 = new ParkingLot(10);
        Car w_car = new Car("MH11211", "White");
        w_parkingLot4.allocateSlotToParkCar(w_car);
        assertEquals("Remaining slots are: 9", w_parkingLot4.getRemainingSlotStatus());
    }

}
