package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
	
	ParkingLot parkingLot;
	public final int capacity = 2;
	
	@Before
	public void setUp(){
		parkingLot = new ParkingLot(capacity);
	}
	
	@Test
	public void testGetSlot() {
		assertTrue(parkingLot.getSlot()==1);
		assertTrue(parkingLot.getSlot()==2);
		assertTrue(parkingLot.getSlot()==-1);
	}
	
	@Test 
	public void testFreeUpSlot() {
		assertTrue(parkingLot.getSlot()==1);
		assertTrue(parkingLot.getSlot()==2);
		assertTrue(parkingLot.getSlot()==-1);
		
		parkingLot.freeUpSlot(2);
		assertTrue(parkingLot.getSlot()==2);
		
		parkingLot.freeUpSlot(1);
		assertTrue(parkingLot.getSlot()==1);
	}

}
