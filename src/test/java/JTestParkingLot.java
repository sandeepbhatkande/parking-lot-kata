
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.digite.kata.ParkingLot;


public class JTestParkingLot {

    @Test
    public void create_parking_lot()
    {
    	ParkingLot w_ParkingLot = new ParkingLot(6);
    	System.out.println("Created a parking lot with " +w_ParkingLot.getparkingSlotCount() +" slot");
    	assertEquals(w_ParkingLot.getparkingSlotCount(), 6);
    }
}