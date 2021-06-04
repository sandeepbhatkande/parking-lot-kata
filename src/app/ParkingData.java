package app;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingData {
	
	private Parking parkinglot;
	
	public ParkingData(Parking a_parking) {
		parkinglot = a_parking;
	}

	public ArrayList<String> registrationNumbersByColor(String a_color){
		ArrayList<String> w_regStringList = new ArrayList<String>();
		HashMap<Integer, Car> w_parkingMap = parkinglot.getMAP();
		MaintainSlot w_slotInformation = parkinglot.getSlotInformation();
		int w_sizeLimit = w_slotInformation.getSize();
		
		for(int i = 1;i<=w_sizeLimit;i++) {
			if(w_parkingMap.containsKey(i)) {
				Car w_car = w_parkingMap.get(i);
				if(w_car.getColor().equals(a_color))
				{
					w_regStringList.add(w_car.getNumber());
				}
			}
		}
		
		return w_regStringList;
	}
	
	public int slotNumber(String a_registrationNumber) {
		HashMap<Integer, Car> w_parkingMap = parkinglot.getMAP();
		MaintainSlot w_slotInformation = parkinglot.getSlotInformation();
		int w_sizeLimit = w_slotInformation.getSize();
		
		for(int i = 1;i<w_sizeLimit;i++) {
			if(w_parkingMap.containsKey(i)) {
				Car w_car = w_parkingMap.get(i);
				if(w_car.getNumber().equals(a_registrationNumber))
				{
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public ArrayList<Integer> slotNumbersBycolor(String a_color) {
		ArrayList<Integer> w_slotList = new ArrayList<Integer>();
		HashMap<Integer, Car> w_parkingMap = parkinglot.getMAP();
		MaintainSlot w_slotInformation = parkinglot.getSlotInformation();
		int w_sizeLimit = w_slotInformation.getSize();
		
		for(int i = 1;i<=w_sizeLimit;i++) {
			if(w_parkingMap.containsKey(i)) {
				Car w_car = w_parkingMap.get(i);
				if(w_car.getColor().equals(a_color))
				{
					w_slotList.add(i);
				}
			}
		}
		
		
		return w_slotList;
		
	}
}
