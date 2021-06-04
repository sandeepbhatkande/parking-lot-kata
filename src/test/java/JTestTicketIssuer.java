import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.Car;
import com.digite.kata.tracker.ParkingLot;
import com.digite.kata.tracker.TicketIssuer;

public class JTestTicketIssuer
{
    @Test
    public void testGetAllocatedSlotNo()
    {
        ParkingLot w_parkingLot = new ParkingLot(10);
        Car w_car = new Car("White", "MH-03-9000", "Hitesh Narwani");
        TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
        String w_allocatedNo = "Allocated slot number: 1";
        Assertions.assertEquals(w_allocatedNo, w_issuer.getAllocatedSlotNo(w_car));
        
        Car w_car1 = new Car("White", "MH-03-9001", "Sandeep Bhatkande");
        String w_allocatedNo1 = "Allocated slot number: 2";
        Assertions.assertEquals(w_allocatedNo1, w_issuer.getAllocatedSlotNo(w_car1));

    }
    
    @Test 
	public void testExceedsParkingLimit() 
	{
		 ParkingLot w_parkingLot = new ParkingLot(3);
		 TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
		  
		 Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	     Assertions.assertEquals("Allocated slot number: 1", w_issuer.getAllocatedSlotNo(w_car1));
	        
	     Car w_car2 = new Car("Red", "MH-03-9002", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 2", w_issuer.getAllocatedSlotNo(w_car2));
	        
	     Car w_car3 = new Car("White", "MH-03-9003", "Amey Patil");
	     Assertions.assertEquals("Allocated slot number: 3", w_issuer.getAllocatedSlotNo(w_car3));
		     	
		 Car w_car4 = new Car("Black", "MH-03-9004", "Sakshe Goja");
		 Assertions.assertEquals("Sorry, parking lot is full",
		 w_issuer.getAllocatedSlotNo(w_car4));
			 
	 }
    
     @Test
     public void testLeaveCar()
     {
		 ParkingLot w_parkingLot = new ParkingLot(5);
		 TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
		
		 Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
	     Assertions.assertEquals("Allocated slot number: 1", w_issuer.getAllocatedSlotNo(w_car1));
	    
	     Car w_car2 = new Car("White", "MH-03-9002", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 2", w_issuer.getAllocatedSlotNo(w_car2));
	    
	     Car w_car3 = new Car("White", "MH-03-9003", "Sandeep Bhatkande");
	     Assertions.assertEquals("Allocated slot number: 3", w_issuer.getAllocatedSlotNo(w_car3));
	   
	     String w_freedSlotNo = w_issuer.leaveCar(2);
	     Assertions.assertEquals("Slot number 2 is free", w_freedSlotNo);
          	
     }
    
    @Test
    public void testLeaveCarAndAllocateAnother()
    {
    	ParkingLot w_parkingLot = new ParkingLot(5);
    	TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
    	
        Car w_car1 = new Car("White", "MH-03-9000", "Hitesh Narwani");  
        Assertions.assertEquals("Allocated slot number: 1", w_issuer.getAllocatedSlotNo(w_car1));
        
        Car w_car2 = new Car("White", "MH-03-9002", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 2", w_issuer.getAllocatedSlotNo(w_car2));
        
        Car w_car3 = new Car("White", "MH-03-9003", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 3", w_issuer.getAllocatedSlotNo(w_car3));
       
        String w_freedSlotNo = w_issuer.leaveCar(2);
        Assertions.assertEquals("Slot number 2 is free", w_freedSlotNo);
        
        Car w_car4 = new Car("White", "MH-03-9004", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 2", w_issuer.getAllocatedSlotNo(w_car4));
        
        Car w_car5 = new Car("White", "MH-03-9005", "Sandeep Bhatkande");
        Assertions.assertEquals("Allocated slot number: 4", w_issuer.getAllocatedSlotNo(w_car5));
          	
    }
		  
}