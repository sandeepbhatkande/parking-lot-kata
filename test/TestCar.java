import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCar
{

    @Test
    public void newcar() {
        Car w_car = new Car("car1", "white");
    }

    @Test
    public void cardetails() {
        Car w_car = new Car("car1","black"  );
        assertTrue("car1".equals(w_car.getRegistrationNo()));
        assertTrue("black".equals(w_car.getColor()));
    }

}
