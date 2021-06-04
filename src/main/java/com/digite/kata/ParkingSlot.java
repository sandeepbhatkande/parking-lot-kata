package com.digite.kata;

import java.util.HashMap;

public class ParkingSlot {
    int parkingLotCount;
    HashMap<Integer, Car> w_parkedCars;

    public ParkingSlot(int parkingLotCount) {
        this.parkingLotCount = parkingLotCount;
        this.w_parkedCars = new HashMap<Integer, Car>();
    }

    public void parkCar(Car w_car) throws Exception {
        int parkingLot = searchNearestParkingSlot();
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
            w_parkedCars.remove(parkingLot);
            System.out.println("Car with reg no " + existingCar.getRegistrationNumber() + " and color " + existingCar.getColor()
                    + " is left position " + parkingLot);

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

    public int searchNearestParkingSlot() {
        int emptySlot = 0;
        for (int i = 1; i <= parkingLotCount; i++){
            Car existingCar = w_parkedCars.get(i);
            if (existingCar == null) {
                emptySlot = i;
                break;
            }
        }
        return emptySlot;
    }
}
