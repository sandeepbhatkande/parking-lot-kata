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
    public  void testEachSlotInfo()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Assertions.assertEquals(10, w_parkLot.getAllSlotsInfo().size());
        for (int i = 0 ; i< 10; i++)
        {
            Assertions.assertEquals(true, w_parkLot.getAllSlotsInfo().get(i).getIsAvailable());
        }

    }
}
