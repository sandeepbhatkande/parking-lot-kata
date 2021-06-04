
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
    void testcar() throws Exception {
        Car car = new Car("MH 02 123456", "Black");

        Map<Integer, Car> parkedCars = slot.getSlot_map();
        assertEquals(1, slot.parkCarandGetSlotNo( car));
    }


}
