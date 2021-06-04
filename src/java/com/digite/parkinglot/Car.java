package com.digite.parkinglot;

public class Car {
    private String REG_NO = null;
    private String COLOR = null;

    public Car(String regNo, String color) {
        this.REG_NO = regNo;
        this.COLOR = color;
    }

    public String getREG_NO() {
        return REG_NO;
    }

    public void setREG_NO(String REG_NO) {
        this.REG_NO = REG_NO;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }
}
