package com.digite.kata;

public class Car {
    String registrationNumber;
    String color;
    int parkingSlot;

    public Car(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }
}
