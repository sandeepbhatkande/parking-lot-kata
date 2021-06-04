package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingDetailsRepoTest {

	@Test
	public void testParkingDetailsRepo() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 10;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		parkingDetailsRepo.addDetails(parkingDetails);
	}

	@Test
	public void testGetDetailsBySlot() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 10;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		parkingDetailsRepo.addDetails(parkingDetails);
		
		ParkingDetails responseDetails = parkingDetailsRepo.getDetailsBySlot(slotId);
		assertTrue(responseDetails.getCar().equals(car));
		assertTrue(responseDetails.getSlotId() == slotId);
		assertTrue(responseDetails.isParked() == true);
	}
	
	@Test
	public void testRemoveParkedCar() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 10;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		parkingDetailsRepo.addDetails(parkingDetails);
		parkingDetailsRepo.removeParkedCar(slotId);
		assertEquals(parkingDetailsRepo.getDetailsBySlot(slotId),null);
	}
}
