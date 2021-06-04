package com.parkingapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingDetailsRepo {
	
	private ArrayList<ParkingDetails> repo;
	private HashMap<Integer, ParkingDetails> parkedCars;
	
	public ParkingDetailsRepo() {
		repo = new ArrayList<ParkingDetails>();
		parkedCars = new HashMap<Integer, ParkingDetails>();
	}

	public void addDetails(ParkingDetails parkingDetails) {
		repo.add(parkingDetails);
		if(parkingDetails.isParked()) {
			parkedCars.put(parkingDetails.getSlotId(), parkingDetails);
		}
	}
	
	public ParkingDetails getDetailsBySlot(int slotId) {
		return parkedCars.get(slotId);
	}
	
	public void removeParkedCar(int slotId) {
		parkedCars.get(slotId).setParked(false);
		parkedCars.remove(slotId);
	}

	public List<ParkingDetails> getDetailsByColor(String color) {
		return repo
				.stream()
				.filter(details -> color.equals(details.getCar().getColor()))
				.collect(Collectors.toList());
	}

	public String getSlotIdByRegistrationNumber(String registrationNumber) {
		for(int slot  : parkedCars.keySet()) {
			if(parkedCars.get(slot).getCar().getRegistrationNumber().equals(registrationNumber))
				return String.valueOf(slot);
		}
		return "Not found";
	}

	public ArrayList<Integer> getSlotsByColors(String color) {
		ArrayList<Integer> slotIds = new ArrayList<>();
		for(int slot  : parkedCars.keySet()) {
			if(parkedCars.get(slot).getCar().getColor().equals(color))
				slotIds.add(slot);
		}
		return slotIds;
	}
}
