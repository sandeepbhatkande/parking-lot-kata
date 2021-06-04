package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingServiceTest {
	
	ParkingService parkingService;
	
	@Before
	public void setup() {
		parkingService = new ParkingService();
	}

	@Test
	public void testPark() {
		Car car = new Car("KA-01-HH-1234", "White");
		assertTrue("Allocated slot number: 1".equals(parkingService.park(car)));
	}

}
