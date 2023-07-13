package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void testgetSlotListOfSameColor()
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

        Assertions.assertEquals(2, w_parkLot.getSlotListOfSameColor("Blue").size());
        Assertions.assertEquals(2, w_parkLot.getSlotListOfSameColor("Blue").get(0));
        Assertions.assertEquals(3,  w_parkLot.getSlotListOfSameColor("Blue").get(1));
    }

    //given test case in Readme.MD
    @Test
    public void testDisplayCurrentStatus()
    {
        ParkingLot w_parkLot = new ParkingLot(6);
        Car w_car1 = new Car("White","KA-01-HH-1234", "Peter"); w_parkLot.park(w_car1);
        Car w_car2 = new Car("White","KA-01-HH-9999", "Olivia"); w_parkLot.park(w_car2);
        Car w_car3 = new Car("Black","KA-01-BB-0001", "Walter"); w_parkLot.park(w_car3);
        Car w_car4 = new Car("Red","KA-01-HH-7777", "Bishop"); w_parkLot.park(w_car4);
        Car w_car5 = new Car("Blue","KA-01-HH-2701", "John"); w_parkLot.park(w_car5);
        Car w_car6 = new Car("Black","KA-01-HH-3141", "Astrid"); w_parkLot.park(w_car6);
        w_parkLot.Leave(w_car4);
        Car w_car7 = new Car("White","KA-01-P-333", "Liam"); w_parkLot.park(w_car7);
        Car w_car8 = new Car("White","DL-12-AA-9999", "Scott"); w_parkLot.park(w_car8);

        String w_status = w_parkLot.getCurrentStatus();
        Assertions.assertEquals("SlotNo|CarNo|CarColor|CarOwner|\n" +
                "1|KA-01-HH-1234|White|Peter|\n" +
                "2|KA-01-HH-9999|White|Olivia|\n" +
                "3|KA-01-BB-0001|Black|Walter|\n" +
                "4|KA-01-P-333|White|Liam|\n" +
                "5|KA-01-HH-2701|Blue|John|\n" +
                "6|KA-01-HH-3141|Black|Astrid|\n", w_status);
    }


}
