package com.parkingapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ParkingDetailsRepoTest {

	@Test
	public void testParkingDetailsRepo() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 1;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		parkingDetailsRepo.addDetails(parkingDetails);
	}

	@Test
	public void testGetDetailsBySlot() {
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 1;
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
		int slotId = 1;
		boolean parked = true;
		
		ParkingDetails parkingDetails = new ParkingDetails(car, slotId, parked);
		
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		parkingDetailsRepo.addDetails(parkingDetails);
		parkingDetailsRepo.removeParkedCar(slotId);
		assertEquals(parkingDetailsRepo.getDetailsBySlot(slotId),null);
	}
	
	@Test
	public void testRegistrationNumbersForCarsWithColour() {
		ParkingDetailsRepo parkingDetailsRepo = new ParkingDetailsRepo();
		ParkingDetails parkingDetails;
		
		Car car = new Car("KA-01-HH-1234", "White");
		int slotId = 1;
		boolean parked = true;
		parkingDetails = new ParkingDetails(car, slotId, parked);
		parkingDetailsRepo.addDetails(parkingDetails);
		
		car = new Car("KA-01-HH-1235", "White");
		slotId = 2;
		parked = true;
		parkingDetails = new ParkingDetails(car, slotId, parked);
		parkingDetailsRepo.addDetails(parkingDetails);
		
		car = new Car("KA-01-HH-1236", "Red");
		slotId = 3;
		parked = true;
		parkingDetails = new ParkingDetails(car, slotId, parked);
		parkingDetailsRepo.addDetails(parkingDetails);
		
		List<ParkingDetails> details = parkingDetailsRepo.getDetailsByColor("White");
		assertTrue(details.size()==2);
		assertTrue("KA-01-HH-1234".equals(details.get(0).getCar().getRegistrationNumber()));
		assertTrue("KA-01-HH-1235".equals(details.get(1).getCar().getRegistrationNumber()));
	}

}
