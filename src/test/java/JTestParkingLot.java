import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.digite.kata.parkinglot.ParkingLot;


public class JTestParkingLot
{
    @Test
    public void testGetTotalSlots()
    {
        ParkingLot pl = new ParkingLot(6);
        pl.getTotalSlots();
        
        assertEquals(6, pl.getTotalSlots());  
    }

}