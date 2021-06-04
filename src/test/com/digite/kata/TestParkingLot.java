package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParkingLot
{
    @Test
    public  void testgetParkingLotForNegativeVal()
    {
        ParkingLot w_parkLot = new ParkingLot(-1);
        Assertions.assertEquals(0, w_parkLot.getTotalSlot());
    }

    @Test
    public  void testgetParkingLotForPositiveVal()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Assertions.assertEquals(10, w_parkLot.getTotalSlot());
    }

    @Test
    public void testAvailableSlotListAtIntial()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Assertions.assertEquals(10, w_parkLot.getAvailableSlotList().size());
    }

    @Test
    public void testBookedSlotListAtIntial()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Assertions.assertEquals(0, w_parkLot.getBookedSlotList().size());
    }

    @Test
    public void TestParkCarInfoAvailableList()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Assertions.assertEquals(9, w_parkLot.getAvailableSlotList().size());
    }

    @Test
    public void TestParkCarInfoBookedList()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Assertions.assertEquals(1, w_parkLot.getBookedSlotList().size());
    }

    @Test
    public void TestMessageAfterCarIsParked()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        Assertions.assertEquals("Name : Shraddha, Parking Slot : 1, Registeration No: MH-03-9000, Color: Red",  w_parkLot.park(w_car));
    }




}
