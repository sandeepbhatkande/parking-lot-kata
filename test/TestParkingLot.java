
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParkingLot {

    ParkingLot slot;

    @BeforeAll
    public   void setup() {
        slot = new ParkingLot(10);
    }

    @Test
    void testcarpark() throws Exception {
        Car car = new Car("MH 02 123456", "Black");


        assertEquals(1, slot.parkCarandGetSlotNo( car));
    }

    @Test
    void testcarparkfull() throws Exception {

        Car car;// =
        for (int z=0; z<10; z++ ) {
            car=new Car("car"+z,"white");
            slot.parkCarandGetSlotNo( car);
        }
        car = new Car("MH 02 123456", "Black");
        assertEquals(-1, slot.parkCarandGetSlotNo( car));
    }
    @Test
    void TestLeaveCar() throws Exception {
        assertEquals("Slot number 6 is free",slot.leaveCar(6));
    }

    @Test
    void TestgetRegfromColor() throws Exception {
        Car car=new Car("MH 02 12345", "white");
        slot.parkCarandGetSlotNo(car);
        assertEquals("car with black color not found",slot.getRegfromColor("black"));
        car = new Car("MH 02 123456", "black");
        slot.parkCarandGetSlotNo(car);
        car=new Car("MH 02 1234", "yellow");
        slot.parkCarandGetSlotNo(car);
        assertEquals("MH 02 123456",slot.getRegfromColor("black"));

    }
}
