package com.digite.kata;

import java.util.HashMap;

public class ParkingSlot {
    int parkingLotCount;
    HashMap<Integer, Car> w_parkedCars;

    public ParkingSlot(int parkingLotCount) {
        this.parkingLotCount = parkingLotCount;
        this.w_parkedCars = new HashMap<Integer, Car>();
        System.out.println("Created a parking lot with " + parkingLotCount + " slots");
    }

    public void parkCar(Car w_car) throws Exception {
        int parkingLot = searchNearestParkingSlot();
        if (w_parkedCars.size() <= parkingLotCount && parkingLot != 0) {
            w_car.setParkingSlot(parkingLot);
            w_parkedCars.put(parkingLot, w_car);
            System.out.println("Allocated slot number: " + parkingLot);
        }
        else
        {
            throw new Exception("Sorry, parking lot is full");
        }
    }

    public HashMap<Integer, Car> getParkedCars() {
        return w_parkedCars;
    }

    public void leaveCar(int parkingLot) throws Exception {
        Car existingCar = w_parkedCars.get(parkingLot);
        if (existingCar != null) {
            w_parkedCars.remove(parkingLot);
            System.out.println("Slot number " + parkingLot + " is free");
        }
        else
            throw new Exception("Slot is already empty");
    }
    public void getParkingLogStatus()
    {
        System.out.println("Slot No.    Registration No     Colour");
        for (Integer parkingSlot: w_parkedCars.keySet())
        {
            Car car = w_parkedCars.get(parkingSlot);
            System.out.println(parkingSlot + "           " + car.getRegistrationNumber() + "       " + car.getColor());
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

    public HashMap<Integer, Car> searchCarsBasedOnColor(String color) {
        HashMap<Integer, Car> w_searchdCars = new HashMap<Integer, Car>();
        for (Integer parkingSlot: w_parkedCars.keySet()) {
            Car car = w_parkedCars.get(parkingSlot);
            if (color.equals(car.getColor()))
                w_searchdCars.put(parkingSlot, car);
        }
        return w_searchdCars;
    }

    public Car searchCarsBasedOnRegNo(String RegNo) throws Exception {
        Car w_searchdCars = null;
        for (Integer parkingSlot: w_parkedCars.keySet()) {
            Car car = w_parkedCars.get(parkingSlot);
            if (RegNo.equals(car.getRegistrationNumber()))
                w_searchdCars = car;
        }
        if (w_searchdCars == null)
            throw new Exception("Not found");

        return w_searchdCars;
    }
}
