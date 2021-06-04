
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.digite.kata.Car;
import com.digite.kata.ParkingLot;

public class JTestParkingLot {
    
	@Test
    public void create_parking_lot()
    {
    	System.out.println("---- TDD create_parking_lot Stated---------");
    	ParkingLot w_ParkingLot = new ParkingLot(6);
    	System.out.println("Created a parking lot with " +w_ParkingLot.getparkingSlotCount() +" slot");
    	assertEquals(w_ParkingLot.getparkingSlotCount(), 6);
    }
    
    
    @Test
    public void AllocatedSlotforCar()
    {
    	System.out.println("---- TDD AllocatedSlotforCar Stated---------");
    	ParkingLot w_ParkingLot = new ParkingLot(6);
    	Car w_car1 = new Car("AC-mh-002","White", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car1), "Allocated slot number:1");
    	
    	Car w_car2 = new Car("AC-mh-003","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car2), "Allocated slot number:2");
    }

    @Test
    public void ExceedtheCarSlotCapacity()
    {
    	System.out.println("---- TDD ExceedtheCarSlotCapacity Stated---------");
    	ParkingLot w_ParkingLot = new ParkingLot(3);
    	
    	Car w_car1 = new Car("KA-01-P-001","White", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car1), "Allocated slot number:1");
    	
    	Car w_car2 = new Car("KA-01-P-002","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car2), "Allocated slot number:2");
    	
    	Car w_car3 = new Car("KA-01-P-003","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car3), "Allocated slot number:3");
    	
    	Car w_car4 = new Car("KA-01-P-004","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car4), "Sorry, parking lot is full");
    }
    

    @Test
    public void RemoveCar()
    {
    	System.out.println("---- TDD RemoveCar Stated---------");
    	ParkingLot w_ParkingLot = new ParkingLot(3);
    	
    	Car w_car1 = new Car("KA-01-P-001","White", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car1), "Allocated slot number:1");
    	
    	Car w_car2 = new Car("KA-01-P-002","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car2), "Allocated slot number:2");
    	
    	Car w_car3 = new Car("KA-01-P-003","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car3), "Allocated slot number:3");
    
    	assertEquals(w_ParkingLot.RemoveCar(w_car2), "Slot number 2 is free");
    }
    
    
    @Test
    public void RemoveCarSlot_AllocateToNewCar()
    {
    	System.out.println("---- TDD RemoveCarSlot_AllocateToNewCar Stated---------");
    	ParkingLot w_ParkingLot = new ParkingLot(4);
    	
    	Car w_car1 = new Car("KA-01-P-001","White", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car1), "Allocated slot number:1");
    	
    	Car w_car2 = new Car("KA-01-P-002","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car2), "Allocated slot number:2");
    	
    	Car w_car3 = new Car("KA-01-P-003","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car3), "Allocated slot number:3");
    
    	Car w_car4 = new Car("KA-01-P-004","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car4), "Allocated slot number:4");
    	
    	assertEquals(w_ParkingLot.RemoveCar(w_car3), "Slot number 3 is free");
    	assertEquals(w_ParkingLot.RemoveCar(w_car2), "Slot number 2 is free");
    	
    	Car w_car5 = new Car("KA-01-P-005","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car5), "Allocated slot number:2");
    	
    	Car w_car6 = new Car("KA-01-P-006","Black", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car6), "Allocated slot number:3");
    }
}