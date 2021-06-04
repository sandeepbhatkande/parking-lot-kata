package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.*;

import app.*;

public class testParkingData {
	
	@Test
	public void testRegistrationNumbersByColor(){
		Parking w_parking = new Parking(10);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue";
		w_parking.addCar(w_registration, w_color);
		w_registration = "KA-01-HH-9999";
		w_color = "Blue";
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-7653";
		w_color = "Black";
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-2112";
		w_color = "Black";
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HB-8659";
		w_color = "Black";
		w_parking.addCar(w_registration, w_color);
		w_registration = "WB-01-HB-1977";
		w_color = "Red";
		w_parking.addCar(w_registration, w_color);
		w_registration = "WB-01-HB-2011";
		w_color = "Red";
		w_parking.addCar(w_registration, w_color);
		ParkingData w_pdata = new ParkingData(w_parking);
		
		assertTrue(w_pdata.registrationNumbersByColor("Red").contains("WB-01-HB-1977"));
		assertTrue(w_pdata.registrationNumbersByColor("Red").contains("WB-01-HB-2011"));
		assertEquals(w_pdata.registrationNumbersByColor("Red").size(),2);
		assertTrue(w_pdata.registrationNumbersByColor("Black").contains("TN-01-HH-7653"));
		assertTrue(w_pdata.registrationNumbersByColor("Black").contains("TN-01-HB-8659"));
		assertTrue(w_pdata.registrationNumbersByColor("Black").contains("TN-01-HH-2112"));
		assertEquals(w_pdata.registrationNumbersByColor("Black").size(),3);
		assertTrue(w_pdata.registrationNumbersByColor("Blue").contains("KA-01-HH-1234"));
		assertTrue(w_pdata.registrationNumbersByColor("Blue").contains("KA-01-HH-9999"));
		assertEquals(w_pdata.registrationNumbersByColor("Blue").size(),2);
		
	}
	
	@Test
	public void testSlotNumber() {
		Parking w_parking = new Parking(10);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue"; //1
		w_parking.addCar(w_registration, w_color);
		w_registration = "KA-01-HH-9999";
		w_color = "Blue"; //2
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-7653";
		w_color = "Black"; //3
		w_parking.addCar(w_registration, w_color);

		ParkingData w_pdata = new ParkingData(w_parking);
		

		assertEquals(w_pdata.slotNumber("KA-01-HH-1234"),1);
		assertEquals(w_pdata.slotNumber("KA-01-HH-9999"),2);
		assertEquals(w_pdata.slotNumber("TN-01-HH-7653"),3);
	}
	
	@Test
	public void testSlotNumbersBycolor() {
		Parking w_parking = new Parking(10);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue"; //1
		w_parking.addCar(w_registration, w_color);
		w_registration = "KA-01-HH-9999";
		w_color = "Blue"; //2
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-7653";
		w_color = "Black"; //3
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HH-2112";
		w_color = "Black"; //4
		w_parking.addCar(w_registration, w_color);
		w_registration = "TN-01-HB-8659";
		w_color = "Black"; //5
		w_parking.addCar(w_registration, w_color);
		w_registration = "WB-01-HB-1977";
		w_color = "Red"; //6
		w_parking.addCar(w_registration, w_color);
		w_registration = "WB-01-HB-2011";
		w_color = "Red"; //7
		w_parking.addCar(w_registration, w_color);
		ParkingData w_pdata = new ParkingData(w_parking);
		
		assertTrue(w_pdata.slotNumbersBycolor("Red").contains(6));
		assertTrue(w_pdata.slotNumbersBycolor("Red").contains(7));
		assertEquals(w_pdata.slotNumbersBycolor("Red").size(),2);
		assertTrue(w_pdata.slotNumbersBycolor("Black").contains(3));
		assertTrue(w_pdata.slotNumbersBycolor("Black").contains(4));
		assertTrue(w_pdata.slotNumbersBycolor("Black").contains(5));
		assertEquals(w_pdata.slotNumbersBycolor("Black").size(),3);
		assertTrue(w_pdata.slotNumbersBycolor("Blue").contains(1));
		assertTrue(w_pdata.slotNumbersBycolor("Blue").contains(2));
		assertEquals(w_pdata.slotNumbersBycolor("Blue").size(),2);
	
		
	}

}
