package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingDetailsTest {

	@Test
	public void testParkingDetails() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 10;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		assertTrue(parkingDetails.getCar().equals(car));
		assertTrue(parkingDetails.getSlotId() == slotId);
		assertTrue(parkingDetails.isParked() == true);
		
		parkingDetails.setParked(false);
		assertTrue(parkingDetails.isParked() == false);
	}
	
}
