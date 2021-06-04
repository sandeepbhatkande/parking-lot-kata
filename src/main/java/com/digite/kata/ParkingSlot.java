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
}
