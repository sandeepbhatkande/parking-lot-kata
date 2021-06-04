package com.digite.kata;

import org.junit.jupiter.api.*;

import java.util.HashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestParkingSlot {

    static ParkingSlot slot;

    @BeforeAll
    public static void setup() {
        slot = new ParkingSlot(10);
    }

    @Test
    @Order(1)
    public void testParkFirstCar() throws Exception {
        Car car = new Car("MH 02 123456", "Black");
        slot.parkCar(1, car);
        HashMap<Integer, Car> parkedCars = slot.getParkedCars();
        Assertions.assertEquals(1, parkedCars.get(1).getParkingSlot());
    }

    @Test
    @Order(2)
    public void testParkSecondCarAtFullSlot() {
        Car car = new Car("MH 02 123457", "White");

        try {
            slot.parkCar(1, car);
        } catch (Exception e) {
            Assertions.assertEquals("Slot 1 is already full", e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void testLeaveCar() throws Exception {
        slot.leaveCar(1);
        HashMap<Integer, Car> w_parkedCars = slot.getParkedCars();
        slot.getParkingLogStatus();
        Assertions.assertTrue(!w_parkedCars.containsKey(1));
    }

    @Test
    @Order(4)
    public void testLeaveCarWhenSlotIsEmpty() {
        try {
            slot.leaveCar(1);
        } catch (Exception e) {
            Assertions.assertEquals("Slot is already empty", e.getMessage());
        }
    }
}
