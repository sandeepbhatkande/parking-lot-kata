package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class ParkingServiceTest {
	
	ParkingService parkingService;
	
	@BeforeAll
	public void setup() {
		parkingService = new ParkingService();
	}

	@Test
	public void testPark() {
		Car car = new Car("KA-01-HH-1234", "White");
		assertTrue("Allocated slot number: 1".equals(parkingService.park(car)));
	}
	
	@Test
	public void testLeave() {
		int slotId = 1;
		Car car = new Car("KA-01-HH-1234", "White"); 
		assertTrue("Slot number 1 is free".equals(parkingService.leave(slotId)));
	}

}
