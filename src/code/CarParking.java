package code;

import java.util.HashMap;

public class CarParking 
{
	private HashMap<Integer, Car> ParkingDetailsMap; 	
	CarParkingSlotManagment ParkingslotDetails;
	
	public CarParking(int a_parkingSlotSize)
	{
		ParkingDetailsMap = new HashMap<Integer, Car>();
		ParkingslotDetails = new CarParkingSlotManagment(a_parkingSlotSize);
	}
	
	public boolean CarEntry(String a_CarNo, String a_CarColor) 
	{
		Car w_car = new Car(a_CarNo, a_CarColor);
		boolean w_isEmptySlotAvailable = ParkingslotDetails.emptySlotPresent(); 
		if(w_isEmptySlotAvailable)
		{
			int carSlot = ParkingslotDetails.nearestEntry();
			ParkingDetailsMap.put(carSlot, w_car);
			return true;
		}
		return false;
	}
	
	public boolean CarExit(int a_slot) 
	{
		boolean w_isSlotPresent = ParkingDetailsMap.containsKey(a_slot);
		if(w_isSlotPresent)
		{
			ParkingslotDetails.markedSlotEmpty(a_slot);
			ParkingDetailsMap.remove(a_slot);
			return true;
		}
		return false;
	}
	
	public HashMap<Integer, Car> getParkingDetailsMap()
	{
		return ParkingDetailsMap;
	}
	
	public CarParkingSlotManagment getSlotInformation()
	{
		return ParkingslotDetails;
	}
}
