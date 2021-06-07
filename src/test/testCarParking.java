package test;

import static org.junit.Assert.assertTrue;
import org.junit.*;
import app.*;

public class testCarParking  
{
	@Test
	public void testCarEntry() 
	{
		CarParking w_parking = new CarParking(2);
		
		String w_registration = "KA-01-HH-1234";
		String w_color = "White";
		assertTrue(w_parking.CarEntry(w_registration, w_color));
		
		w_registration = "KA-01-HH-9999";
		w_color = "Red";
		assertTrue(w_parking.CarEntry(w_registration, w_color));
		
		w_registration = "TN-01-HH-7653";
		w_color = "Black";
		assertTrue(!w_parking.CarEntry(w_registration, w_color));
	}
	
	@Test
	public void testCarExit() 
	{
		CarParking w_parking = new CarParking(2);
		
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue"; //Car at slot 1
		w_parking.CarEntry(w_registration, w_color);
		
		w_registration = "KA-01-HH-9999";
		w_color = "Red"; //Car at slot 2
		w_parking.CarEntry(w_registration, w_color);
		
		assertTrue(w_parking.CarExit(1));
		assertTrue(w_parking.CarExit(2));
		
		assertTrue(!w_parking.CarExit(1)); 
	}
}
