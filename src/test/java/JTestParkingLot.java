import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.ParkingLot;

public class JTestParkingLot 
{
	@Test
	public void parkingLotCreated()
	{
		ParkingLot w_parkingLot = new ParkingLot(6);
		assertEquals(6, w_parkingLot.getParkingSlot());
		
	}
}
