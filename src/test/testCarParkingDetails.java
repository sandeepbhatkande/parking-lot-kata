package test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.*;
import app.*;

public class testCarParkingDetails  
{
	@Test
	public void testRegistrationNumbersByColor()
	{
		CarParking w_parking = new CarParking(10);
		
		String w_RegNo = "KA-01-HH-1234";
		String w_color = "Blue";
		w_parking.CarEntry(w_RegNo, w_color);
		
		w_RegNo = "KA-01-HH-9999";
		w_color = "Blue";
		w_parking.CarEntry(w_RegNo, w_color);
		
		ArrayList<String> w_RegNoList = new ArrayList<String> ();
		w_RegNoList.add("KA-01-HH-1234");
		w_RegNoList.add("KA-01-HH-9999");
		
		CarParkingDetails w_pdata = new CarParkingDetails(w_parking);
		assertEquals(w_pdata.getRegNumbersByColor("Blue"),w_RegNoList);
	}
	
	@Test
	public void testSlotNumberByRegNo() 
	{
		CarParking w_parking = new CarParking(3);
		String w_registration = "KA-01-HH-1234";
		String w_color = "Blue"; //Car at slot 1
		w_parking.CarEntry(w_registration, w_color);
		w_registration = "KA-01-HH-9999";
		w_color = "Blue"; //Car at slot 2
		w_parking.CarEntry(w_registration, w_color);
		
		CarParkingDetails w_CarPrkgDetailObj = new CarParkingDetails(w_parking);
		
		assertEquals(w_CarPrkgDetailObj.getCarParkingSlotNumberbyRegNo("KA-01-HH-1234"),1);
		assertEquals(w_CarPrkgDetailObj.getCarParkingSlotNumberbyRegNo("KA-01-HH-9999"),2);
		assertEquals(w_CarPrkgDetailObj.getCarParkingSlotNumberbyRegNo("TN-01-HH-7653"),-1);
	}
	
	@Test
	public void testSlotNumbersBycolor() 
	{
		CarParking w_parking = new CarParking(4);
		
		String w_registration = "TN-01-HH-7653";
		String w_color = "Black";  //Car at slot 1
		w_parking.CarEntry(w_registration, w_color);
		
		w_registration = "WB-01-HB-1977";
		w_color = "Red";  //Car at slot 2
		w_parking.CarEntry(w_registration, w_color);
		
		w_registration = "TN-01-HH-2112";
		w_color = "Black";  //Car at slot 3
		w_parking.CarEntry(w_registration, w_color);
		
		w_registration = "KA-01-HH-1234";
		w_color = "Red";  //Car at slot 4
		w_parking.CarEntry(w_registration, w_color);
		
		CarParkingDetails w_pdata = new CarParkingDetails(w_parking);
		
		ArrayList<Integer> w_BlackCarSlotList = new ArrayList<Integer>();
		w_BlackCarSlotList.add(1);
		w_BlackCarSlotList.add(3);
		
		ArrayList<Integer> w_RedCarSlotList = new ArrayList<Integer>();
		w_RedCarSlotList.add(2);
		w_RedCarSlotList.add(4);
		
		assertEquals(w_pdata.getCarParkingSlotNumbersBycolor("Black"),w_BlackCarSlotList);
		assertEquals(w_pdata.getCarParkingSlotNumbersBycolor("Red"),w_RedCarSlotList);
	}

}
