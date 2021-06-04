package com.digite.kata;

public class MainClass {
    public static void main(String[] args) {
        try {
            //create_parking_lot 6
            ParkingSlot slot = new ParkingSlot(6);
            Car c1 = new Car("KA-01-HH-1234", "White");
            Car c2 = new Car("KA-01-HH-9999", "White");
            Car c3 = new Car("KA-01-BB-0001", "Black");
            Car c4 = new Car("KA-01-HH-7777", "Red");
            Car c5 = new Car("KA-01-HH-2701", "Blue");
            Car c6 = new Car("KA-01-HH-3141", "Black");
            slot.parkCar(c1);
            slot.parkCar(c2);
            slot.parkCar(c3);
            slot.parkCar(c4);
            slot.parkCar(c5);
            slot.parkCar(c6);
            //status
            slot.getParkingLogStatus();
            //leave 4
            slot.leaveCar(4);
            //status
            slot.getParkingLogStatus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
