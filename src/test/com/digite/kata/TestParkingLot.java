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
        Car w_car = new Car("Red", "MH-03-9000", "Shraddha");
        Assertions.assertEquals("Name : Shraddha, Parking Slot : 1, Registeration No: MH-03-9000, Color: Red",  w_parkLot.park(w_car));
    }

    @Test
    public void TestMessageAfterNoParked()
    {
        ParkingLot w_parkLot = new ParkingLot(2);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Blue", "MH-02-4444", "ABC");
        w_parkLot.park(w_car2);
        Car w_car3 = new Car("Blue", "MH-02-4444", "PQR");

        Assertions.assertEquals("No Slots Available",  w_parkLot.park(w_car3));
    }


    @Test
    public void TestLeftCarInfoAvailableList()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        w_parkLot.Leave(w_car);
        Assertions.assertEquals(10, w_parkLot.getAvailableSlotList().size());
    }

    @Test
    public void TestLeftCarInfoBookedList()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        w_parkLot.Leave(w_car);
        Assertions.assertEquals(0, w_parkLot.getBookedSlotList().size());
    }

    @Test
    public void testSlotVsCarMapInfo()
    {

        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Blue", "MH-02-1234", "Peter");
        w_parkLot.park(w_car2);
        Assertions.assertEquals(2, w_parkLot.getSLotWiseCarMap().size());
        Assertions.assertEquals("Shraddha", w_parkLot.getSLotWiseCarMap().get(1).getOwner());
    }

    @Test
    public void testColorWiseCarMap()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Blue", "MH-02-1234", "Peter");
        w_parkLot.park(w_car2);
        Car w_car3 = new Car("Red", "MH-02-5678", "Olivia");
        w_parkLot.park(w_car3);
        Assertions.assertEquals(2, w_parkLot.getColorWiseCarMap().size());
        Assertions.assertEquals(2, w_parkLot.getColorWiseCarMap().get("Red").size());
        Assertions.assertEquals("MH-02-4444", w_parkLot.getColorWiseCarMap().get("Red").get(0));
        Assertions.assertEquals(1, w_parkLot.getColorWiseCarMap().get("Blue").size());
    }

    @Test
    public void testSlotNumberByRegisterationNumber()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Violet", "MH-02-1234", "Peter");
        w_parkLot.park(w_car2);
        Car w_car3 = new Car("Blue", "MH-02-9876", "Olivia");
        w_parkLot.park(w_car3);
        w_parkLot.Leave(w_car2);
        Car w_car4= new Car("Blue", "MH-02-5678", "Astrid");
        w_parkLot.park(w_car4);

        Assertions.assertEquals(2, w_parkLot.getSlotNumberByRegisterationNo("MH-02-5678"));
    }

    @Test
    public void testSlotNumberByWithWrongRegisteration0()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Violet", "MH-02-1234", "Peter");
        w_parkLot.park(w_car2);
        Assertions.assertEquals(0, w_parkLot.getSlotNumberByRegisterationNo("MH-02-5678"));
    }

    @Test
    public void testgetCarRegisterationListOfSameColor()
    {
        ParkingLot w_parkLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-02-4444", "Shraddha");
        w_parkLot.park(w_car);
        Car w_car2 = new Car("Violet", "MH-02-1234", "Peter");
        w_parkLot.park(w_car2);
        Car w_car3 = new Car("Blue", "MH-02-9876", "Olivia");
        w_parkLot.park(w_car3);
        w_parkLot.Leave(w_car2);
        Car w_car4= new Car("Blue", "MH-02-5678", "Astrid");
        w_parkLot.park(w_car4);

        Assertions.assertEquals(2, w_parkLot.getCarListOfSameColor("Blue").size());
        Assertions.assertEquals("MH-02-9876", w_parkLot.getCarListOfSameColor("Blue").get(0));
        Assertions.assertEquals("MH-02-5678",  w_parkLot.getCarListOfSameColor("Blue").get(1));
    }

}
