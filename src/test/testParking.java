package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

import app.*;

public class testParking {

	@Test
	public void testCarEntry() {
		Parking w_parking = new Parking(2);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue";
		assertTrue(w_parking.addCar(w_registration, w_color));
		w_registration = "KA-01-HH-9999";
		w_color = "Red";
		assertTrue(w_parking.addCar(w_registration, w_color));
		w_registration = "TN-01-HH-7653";
		w_color = "Black";
		assertTrue(!w_parking.addCar(w_registration, w_color));
	}
	
	@Test
	public void testCarExit() {
		Parking w_parking = new Parking(2);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue";
		w_parking.addCar(w_registration, w_color);
		w_registration = "KA-01-HH-9999";
		w_color = "Red";
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-7653";
		w_color = "Black";
		assertTrue(w_parking.exitCar(1));
		assertTrue(w_parking.exitCar(2));
		assertTrue(!w_parking.exitCar(1));
		assertTrue(!w_parking.exitCar(2));
	}
}
