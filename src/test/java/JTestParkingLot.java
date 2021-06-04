import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

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
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        
        Car c2 = new Car("KA-01-HH-9999", "White");
        
        Car c3 = new Car("KA-01-BB-0001", "Black");
       
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        
        assertEquals("White", w_list.get(0).getColor());
        assertEquals("KA-01-HH-1234", w_list.get(0).getRegistrationNo()); 
        
        assertEquals("White", w_list.get(1).getColor());
        assertEquals("KA-01-HH-9999", w_list.get(1).getRegistrationNo()); 
        
        assertEquals("Black", w_list.get(2).getColor());
        assertEquals("KA-01-BB-0001", w_list.get(2).getRegistrationNo()); 
      }
    
    
    @Test
    public void testGetCarsListWhenLotIsFull()
    {
        ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        
        Car c2 = new Car("KA-01-HH-9999", "White");
        
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        Car c4 = new Car("KA-01-BB-0001", "Black");
        
        assertEquals("Sorry, parking lot is full", pl.addCars(c4));
      }
    
    @Test
    public void testGetCarsListWhenOneCarIsRemoved() throws Exception
    {
    	ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        HashMap<Integer, Car> w_carsActual = pl.getParkedCars();
        ArrayList<Car> w_list =  pl.getCarList();
       
        pl.leaveCar(1);
        
        Car c4 = new Car("KA-01-HH-7777", "Red");
        
        pl.addCars(c4);
        assertEquals(c4, w_carsActual.get(1));
        assertEquals(c2, w_carsActual.get(2));
        assertEquals(c3, w_carsActual.get(3));
        
     }
    
    @Test
    public void testGetNonAllocatedSlotsWhenCarIsRemoved() throws Exception
    {
    	ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        HashMap<Integer, Car> w_carsActual = pl.getParkedCars();
        ArrayList<Car> w_list =  pl.getCarList();
       
        pl.leaveCar(1);
        
        Car c4 = new Car("KA-01-HH-7777", "Red");
        
        pl.addCars(c4);
        assertEquals(c4, w_carsActual.get(1));
        assertEquals(c2, w_carsActual.get(2));
        assertEquals(c3, w_carsActual.get(3));
        
        ArrayList<Integer> w_nonallocatedSlots = new ArrayList<Integer>(); 
        w_nonallocatedSlots.add(1);
        assertEquals(w_nonallocatedSlots.toString(), pl.getNonAllocatedSlots().toString());
     }
    
    
    @Test
    public void testGetCarByColor()
    {
    	ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Car> w_carsByColor = new ArrayList<Car>();
        w_carsByColor = pl.getCarByColor("White");
        
        assertEquals("White", w_carsByColor.get(0).getColor());
        assertEquals("KA-01-HH-1234", w_carsByColor.get(0).getRegistrationNo()); 
        
        assertEquals("White", w_carsByColor.get(1).getColor());
        assertEquals("KA-01-HH-9999", w_carsByColor.get(1).getRegistrationNo()); 
     }
    
    
    @Test
    public void testGetCarByRegisterNo() throws Exception
    {
    	ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Car> w_carsByColor = new ArrayList<Car>();
        w_carsByColor = pl.getCarByColor("White");
        
        
        Car newCar = pl.getCarByRegistrationNo("KA-01-HH-1234");
        
        assertEquals(c1.getRegistrationNo(), newCar.getRegistrationNo());
     }
    
    @Test
    public void testGetSlotByColor() throws Exception
    {
    	ParkingLot pl = new ParkingLot(3);
        pl.getTotalSlots();
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Car> w_carsByColor = new ArrayList<Car>();
        w_carsByColor = pl.getCarByColor("White");
        
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
        
        Car c1 = new Car("KA-01-HH-1234", "White");
        Car c2 = new Car("KA-01-HH-9999", "White");
        Car c3 = new Car("KA-01-BB-0001", "Black");
        
        pl.addCars(c1);
        pl.addCars(c2);
        pl.addCars(c3);
        
        ArrayList<Car> w_list =  pl.getCarList();
        ArrayList<Car> w_carsByColor = new ArrayList<Car>();
        
        int w_newSlot = pl.getSlotNumberBasedOnNo("KA-01-HH-1234");
        
        assertEquals(1, w_newSlot);
     }
}