import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.Car;
import com.digite.kata.tracker.ParkingLot;
import com.digite.kata.tracker.TicketIssuer;

public class JTestTicketIssuer
{
    @Test
    public void testGetAllocatedSlotNo()
    {
        ParkingLot w_parkingLot = new ParkingLot(10);
        Car w_car = new Car("White", "MH-03-9000", "Hitesh Narwani");
        TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
        String w_allocatedNo = "Allocated slot number: 1";
        Assertions.assertEquals(w_allocatedNo, w_issuer.getAllocatedSlotNo(w_car));
        
        Car w_car1 = new Car("White", "MH-03-9001", "Sandeep Bhatkande");
        String w_allocatedNo1 = "Allocated slot number: 2";
        Assertions.assertEquals(w_allocatedNo1, w_issuer.getAllocatedSlotNo(w_car1));

    }
		  
}