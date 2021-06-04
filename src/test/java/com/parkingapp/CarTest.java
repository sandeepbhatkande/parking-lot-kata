package com.parkingapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void testCreationOfCar() {
		Car car = new Car("KA-01-HH-1234", "White");
	}
	
	@Test
	public void testCarDetails() {
		Car car = new Car("KA-01-HH-1234", "White");
		assertTrue("KA-01-HH-1234".equals(car.getRegistrationNumber()));
		assertTrue("White".equals(car.getColor()));
	}

}
