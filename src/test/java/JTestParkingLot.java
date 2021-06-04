import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.ParkingLot;

public class JTestParkingLot 
{
	@Test
	public void parkingLotCreated()
	{
		ParkingLot w_parkingLot = new ParkingLot(6);
		assertEquals("Created a parking lot with 6 slots", w_parkingLot.getParkingSlot());	
	}
	
	@Test
	public void parkingLotCreateNegativeInput()
	{
		ParkingLot w_parkingLot = new ParkingLot(-1);
		assertEquals("Created a parking lot with 0 slots", w_parkingLot.getParkingSlot());	
	}
	
}
