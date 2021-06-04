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
            slot.parkCar(1, c1);
            slot.parkCar(2, c2);
            slot.parkCar(3, c3);
            slot.parkCar(4, c4);
            slot.parkCar(5, c5);
            slot.parkCar(6, c6);
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
