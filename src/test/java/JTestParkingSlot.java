import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.ParkingLot;
import com.digite.kata.tracker.ParkingSlot;

public class JTestParkingSlot 
{
	@Test
	public void testGetparkingSlotNo()
	{
		ParkingSlot w_parkingSlot = new ParkingSlot(1, true);
		assertEquals(1, w_parkingSlot.getParkingSlotNo());	
	}
	
	@Test
	public void testisParkingSlotAvailable()
	{
		ParkingSlot w_parkingSlot = new ParkingSlot(1, true);
		assertEquals(true, w_parkingSlot.isAvailable());	
	}
}
