import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCar
{

    @Test
    public void newcar() {
        Car c = new Car("car1", "white");
    }

    @Test
    public void cardetails() {
        Car c = new Car("car1","black"  );
        assertTrue("car1".equals(c.getRegistrationNo()));
        assertTrue("black".equals(c.getColor()));
    }

}
