package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParkingSlot
{
    @Test
    public  void testgetParkinSlotNo()
    {
       ParkingSlot w_slot = new ParkingSlot(1, true);
        Assertions.assertEquals(1, w_slot.getParkingSlotNo());
    }

    @Test
    public  void testgetParkinavailable()
    {
        ParkingSlot w_slot = new ParkingSlot(1, true);
        Assertions.assertTrue(w_slot.getIsAvailable());
    }
}
