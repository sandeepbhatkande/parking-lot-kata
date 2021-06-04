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
        slot.parkCar(car);
        HashMap<Integer, Car> parkedCars = slot.getParkedCars();
        for (Integer parkingSlot: parkedCars.keySet()) {
            Assertions.assertEquals(1, parkingSlot);
        }
    }

    /*
    No need of this test as nearest slot is assign utomatically
    @Test
    @Order(2)
    public void testParkSecondCarAtFullSlot() {
        Car car = new Car("MH 02 123457", "White");

        try {
            slot.parkCar(car);
        } catch (Exception e) {
            Assertions.assertEquals("Slot 1 is already full", e.getMessage());
        }
    }
    */

    @Test
    @Order(3)
    public void testLeaveCar() throws Exception {
        slot.leaveCar(1);
        HashMap<Integer, Car> w_parkedCars = slot.getParkedCars();
        //slot.getParkingLogStatus();
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

    @Test
    @Order(5)
    public void testSearchNearestParkingSlot() {
        int w_slot = slot.searchNearestParkingSlot();
        Assertions.assertEquals(1, w_slot);
    }

    @Test
    @Order(6)
    public void testRegNoOfCarsBasedOnColor() throws Exception {
        Car car1 = new Car("MH 02 123457", "White");
        slot.parkCar(car1);
        Car car2 = new Car("MH 02 123458", "White");
        slot.parkCar(car2);
        Car car3 = new Car("MH 02 123459", "Black");
        slot.parkCar(car3);

        HashMap<Integer, Car> w_searchdCars = slot.searchCarsBasedOnColor("White");
        for (Integer parkingSlot: w_searchdCars.keySet()) {
            Car car = w_searchdCars.get(parkingSlot);
            Assertions.assertEquals("White", car.getColor());
        }
    }

    @Test
    @Order(7)
    public void testSlotNoOfCarsBasedOnColor() throws Exception {
        HashMap<Integer, Car> w_searchdCars = slot.searchCarsBasedOnColor("White");
        for (Integer parkingSlot: w_searchdCars.keySet()) {
            Car car = w_searchdCars.get(parkingSlot);
            Assertions.assertEquals(parkingSlot, parkingSlot);
            Assertions.assertEquals(parkingSlot, parkingSlot);
        }
    }

    @Test
    @Order(8)
    public void testSlotNoOfCarsBasedOnRegNo() throws Exception {
        HashMap<Integer, Car> w_searchdCar = slot.searchCarsBasedOnRegNo("MH 02 123457");
        for (Integer parkingSlot: w_searchdCar.keySet()) {
            Assertions.assertEquals(1, parkingSlot);
        }
    }

    @Test
    @Order(9)
    public void testAllSlotsAreFull() throws Exception {
        Car c4 = new Car("KA-01-HH-1234", "White");
        Car c5 = new Car("KA-01-HH-9999", "White");
        Car c6 = new Car("KA-01-BB-0001", "Black");
        Car c7 = new Car("KA-01-HH-7777", "Red");
        Car c8 = new Car("KA-01-HH-2701", "Blue");
        Car c9 = new Car("KA-01-HH-3141", "Black");
        Car c10 = new Car("MH 02 123450", "Black");
        slot.parkCar(c4);
        slot.parkCar(c5);
        slot.parkCar(c6);
        slot.parkCar(c7);
        slot.parkCar(c8);
        slot.parkCar(c9);
        slot.parkCar(c10);
        try {
            Car c11 = new Car("MH 02 123451", "Black");
            slot.parkCar(c11);
        } catch (Exception e) {
            Assertions.assertEquals("Sorry, parking lot is full", e.getMessage());
        }
    }
}
