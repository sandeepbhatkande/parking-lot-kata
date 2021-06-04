package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCar
{
    Car w_car = new Car("Red", "KA-01-HH-1234", "Shraddha");
    @Test
    public  void testgetCarColor()
    {
       Assertions.assertEquals("Red", w_car.getColor());
    }

    @Test
    public  void testgetCarReg()
    {
      Assertions.assertEquals("KA-01-HH-1234", w_car.getRegNo());
    }

    @Test
    public  void testgetCarOwner()
    {
        Assertions.assertEquals("Shraddha", w_car.getOwner());
    }
}

