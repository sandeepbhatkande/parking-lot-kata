package com.digite.kata;

import java.util.HashMap;

public class ParkingSlot {
    int parkingLotCount;
    HashMap<Integer, Car> w_parkedCars;

    public ParkingSlot(int parkingLotCount) {
        this.parkingLotCount = parkingLotCount;
        this.w_parkedCars = new HashMap<Integer, Car>();
    }

    public void parkCar(int parkingLot, Car w_car) throws Exception {
        Car existingCar = w_parkedCars.get(parkingLot);
        if (existingCar == null) {
            w_car.setParkingSlot(parkingLot);
            w_parkedCars.put(parkingLot, w_car);
        }
        else
            throw new Exception("Slot " + parkingLot + " is already full");
    }

    public HashMap<Integer, Car> getParkedCars() {
        return w_parkedCars;
    }

    public void leaveCar(int parkingLot) throws Exception {
        Car existingCar = w_parkedCars.get(parkingLot);
        if (existingCar != null) {
            w_parkedCars.remove(existingCar);
        }
        else
            throw new Exception("Slot is already empty");
    }
    public void getParkingLogStatus()
    {
        for (Integer parkingSlot: w_parkedCars.keySet())
        {
            Car car = w_parkedCars.get(parkingSlot);
            System.out.println("Car with reg no " + car.getRegistrationNumber() + " and color " + car.getColor()
                + " is parked at position " + parkingSlot);
        }
    }

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
