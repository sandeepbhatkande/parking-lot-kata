import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.digite.kata.parkinglot.Car;
import com.digite.kata.parkinglot.ParkingLot;


public class JTestParkingLot
{
    @Test
    public void testGetTotalSlots()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        assertEquals(3, pl.getTotalSlots());  
    }
    
    @Test
    public void testGetCarsListWithoutLeaveCar()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        
        assertEquals("White", w_list.get(0).getColor());
        assertEquals("KA-01-HH-1234", w_list.get(0).getRegistrationNo()); 
        assertEquals(1, w_list.get(0).getSlotNo()); 
        
        assertEquals("White", w_list.get(1).getColor());
        assertEquals("KA-01-HH-9999", w_list.get(1).getRegistrationNo()); 
        assertEquals(2, w_list.get(1).getSlotNo());
        
        assertEquals("Black", w_list.get(2).getColor());
        assertEquals("KA-01-BB-0001", w_list.get(2).getRegistrationNo()); 
        assertEquals(3, w_list.get(2).getSlotNo());
      }
    
    
    @Test
    public void testGetCarsListWhenLotIsFull()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
        
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        int slotNo4 = pl.getNextSlotNumber();
        Car c4 = new Car("KA-01-BB-0001", "Black", slotNo4);
        
        assertEquals("Sorry, parking lot is full", pl.addCarsInList(c4));
      }
    
    @Test
    public void testGetCarsListWhenOneCarIsRemoved()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
       
        pl.leaveCar(c1);
        int slotNo4 = pl.getNextSlotNumber();
        Car c4 = new Car("KA-01-HH-7777", "Red", slotNo4);
        
        pl.addCarsInList(c4);
        
        assertEquals(1, w_list.get(2).getSlotNo());
     }
    
    @Test
    public void testGetNonAllocatedSlotsWhenCarIsRemoved()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
       
        pl.leaveCar(c1);
        ArrayList<Integer> w_allocatedSlots = new ArrayList<Integer>(); 
        w_allocatedSlots.add(1);
        assertEquals(w_allocatedSlots.toString(), pl.getNonAllocatedSlots().toString());
     }
    
    
    @Test
    public void testGetCarByColor()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Car> w_carsByColor = new ArrayList<Car>();
        w_carsByColor = pl.getCarByColor("White");
        
        assertEquals("White", w_carsByColor.get(0).getColor());
        assertEquals("KA-01-HH-1234", w_carsByColor.get(0).getRegistrationNo()); 
        assertEquals(1, w_carsByColor.get(0).getSlotNo()); 
        
        assertEquals("White", w_carsByColor.get(1).getColor());
        assertEquals("KA-01-HH-9999", w_carsByColor.get(1).getRegistrationNo()); 
        assertEquals(2, w_carsByColor.get(1).getSlotNo());
     }
    
    
    @Test
    public void testGetCarByRegisterNo() throws Exception
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        int slot = pl.getNextSlotNumber();
        Car car = new Car("KA-01-HH-1234", "White", slot);
        Car newCar = pl.getCarByRegistrationNo("KA-01-HH-1234");
        
        assertEquals(car.getRegistrationNo(), newCar.getRegistrationNo());
     }
    
    @Test
    public void testGetSlotByColor() throws Exception
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Integer> w_slots = new ArrayList<Integer>();
        w_slots.add(1);
        w_slots.add(2);
        
        ArrayList<Integer> w_newSlots = pl.getSlotNumberBasedOnColor("White");
        
        assertEquals(w_slots.toString(), w_newSlots.toString());
     }
    
    @Test
    public void testGetSlotByNo() throws Exception
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        int slotNo1 = pl.getNextSlotNumber();
        Car c1 = new Car("KA-01-HH-1234", "White", slotNo1);
        
        int slotNo2 = pl.getNextSlotNumber();
        Car c2 = new Car("KA-01-HH-9999", "White", slotNo2);
        
        int slotNo3 = pl.getNextSlotNumber();
        Car c3 = new Car("KA-01-BB-0001", "Black", slotNo3);
       
        pl.addCarsInList(c1);
        pl.addCarsInList(c2);
        pl.addCarsInList(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        
        int w_newSlot = pl.getSlotNumberBasedOnNo("KA-01-HH-1234");
        
        assertEquals(1, w_newSlot);
     }
}