package app;

import java.util.HashMap;

public class Parking {
	private HashMap<Integer, Car> parking_map;	
	MaintainSlot slotInformation;
	
	public Parking(int a_parkingSlotSize) {
		parking_map = new HashMap<Integer, Car>();
		slotInformation = new MaintainSlot(a_parkingSlotSize);
	}
	
	public boolean addCar(String a_carNumber, String a_carColor) {
		Car w_car = new Car(a_carNumber, a_carColor);
		if(slotInformation.emptySlotPresent())
		{
			int carSlot = slotInformation.entry();
			parking_map.put(carSlot, w_car);
			return true;
		}
		return false;
	}
	
	public boolean exitCar(int a_slot) {
		if(parking_map.containsKey(a_slot))
		{
			slotInformation.exit(a_slot);
			parking_map.remove(a_slot);
			return true;
		}
		return false;
	}
	
	public HashMap<Integer, Car> getMAP() {
		return parking_map;
	}
	
	public MaintainSlot getSlotInformation() {
		return slotInformation;
	}
}
