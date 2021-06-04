package com.parkingapp;

public class ParkingDetails {
	
	private Car car;
	private int slotId;
	private boolean parked;
	
	
	public ParkingDetails(Car car, int slotId, boolean parked) {
		this.car = car;
		this.slotId = slotId;
		this.parked = parked;		
	}


	public Car getCar() {
		return car;
	}


	public int getSlotId() {
		return slotId;
	}


	public boolean isParked() {
		return parked;
	}

	public void setParked(boolean parkingStatus) {
		this.parked = parkingStatus;
	}
}
