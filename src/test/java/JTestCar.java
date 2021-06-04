

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.Car;

public class JTestCar
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
