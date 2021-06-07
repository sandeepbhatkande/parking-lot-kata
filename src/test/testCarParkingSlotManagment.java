package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import app.*;

public class testCarParkingSlotManagment  
{
	@Test
	public void testFirstSlot() 
	{
		CarParkingSlotManagment w_CarParSlotMgmtObj = new CarParkingSlotManagment(10);
		w_CarParSlotMgmtObj.nearestEntry();
		assertEquals(w_CarParSlotMgmtObj.returnMin(), 2);
	}
	
	@Test 
	public void testEmptyProperty() 
	{ 
		CarParkingSlotManagment w_CarParSlotMgmtObj = new CarParkingSlotManagment(10); 
		for(int i=0;i<10;i++) 
		{
			assertTrue(w_CarParSlotMgmtObj.emptySlotPresent()); 
			w_CarParSlotMgmtObj.nearestEntry(); 
		}
		assertTrue(!w_CarParSlotMgmtObj.emptySlotPresent());
		assertTrue(w_CarParSlotMgmtObj.nearestEntry()==-1); 
	 }
	 
	
	@Test
	public void testRandomEntryExit() 
	{
		CarParkingSlotManagment w_CarParSlotMgmtObj = new CarParkingSlotManagment(10);
		
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 1);
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 2);
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 3);
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 4);
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 5);
		w_CarParSlotMgmtObj.markedSlotEmpty(2);
		w_CarParSlotMgmtObj.markedSlotEmpty(4);
		assertEquals(w_CarParSlotMgmtObj.nearestEntry(), 2);
	}
}
