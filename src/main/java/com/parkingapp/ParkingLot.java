package com.parkingapp;

public class ParkingLot {
	
	private boolean []slots;
	
	public ParkingLot(int capacity) {
		this.slots = new boolean[capacity];
	}

	public int getSlot() {
		for(int i=0;i<slots.length;i++) {
			if(!slots[i]) {
				slots[i] = true;
				return i+1;
			}
		}
		return -1;
	}

	public void freeUpSlot(int slotId) {
		slots[slotId-1] = false;
	}
	
	
}
