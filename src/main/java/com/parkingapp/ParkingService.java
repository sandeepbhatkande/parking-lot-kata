package com.parkingapp;

public class ParkingService {
	
	ParkingLot parkingLot;
	ParkingDetailsRepo parkingDetailsRepo;
	
	public final int CAPACITY = 6;
	
	public ParkingService() {
		this.parkingLot = new ParkingLot(this.CAPACITY);
		this.parkingDetailsRepo = new ParkingDetailsRepo();
	}

	public String park(Car car) {
		int slotId = parkingLot.getSlot();
		if(slotId==-1) {
			return "Sorry, parking lot is full";
		}else {
			ParkingDetails parkingDetails = new ParkingDetails(car, slotId, true);
			parkingDetailsRepo.addDetails(parkingDetails);
			return "Allocated slot number: " + slotId;
		}
	}

}
