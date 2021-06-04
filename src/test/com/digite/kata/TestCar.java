package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCar
{
    @Test
    public  void testgetCarColor()
    {
        Car w_car = new Car("Red", "KA-01-HH-1234");
        Assertions.assertEquals("Red", w_car.getColor());
    }

    @Test
    public  void testgetCarReg()
    {
        Car w_car = new Car("Red", "KA-01-HH-1234");
        Assertions.assertEquals("KA-01-HH-1234", w_car.getRegNo());
    }
}

