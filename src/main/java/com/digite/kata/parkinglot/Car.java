package com.digite.kata.parkinglot;

public class Car {
    private String registrationNumber;
    private String color;
    public Car(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public void setRegistrationNumber(String registrationNumber) {
    	this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setColor(String color) {
    	this.color = color;
    }

    public String getColor() {
        return color;
    }
}