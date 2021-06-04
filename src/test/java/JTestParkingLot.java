
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import com.digite.kata.Car;
import com.digite.kata.ParkingLot;

public class JTestParkingLot {

    @Test
    public void create_parking_lot()
    {
    	ParkingLot w_ParkingLot = new ParkingLot(6);
    	System.out.println("Created a parking lot with " +w_ParkingLot.getparkingSlotCount() +" slot");
    	assertEquals(w_ParkingLot.getparkingSlotCount(), 6);
    }
    
    
    @Test
    public void Add_Car()
    {
    	ParkingLot w_ParkingLot = new ParkingLot(6);
    	Car w_car1 = new Car("AC-mh-002","White", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car1), "Allocated slot number:1");
    	
    	Car w_car2 = new Car("AC-mh-003","Red", w_ParkingLot.getNextSlotNumber());
    	assertEquals(w_ParkingLot.addCarInList(w_car2), "Allocated slot number:2");
    }
    
}